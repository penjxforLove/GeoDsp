package com.geo.dsp.module.data.service.impl;

import com.geo.dsp.module.data.dto.DataSampleDTO;
import com.geo.dsp.module.data.entity.DataSample;
import com.geo.dsp.module.data.mapper.DataSampleMapper;
import com.geo.dsp.module.data.service.DataSampleService;
import com.geo.dsp.module.data.vo.DataSampleVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DataSampleServiceImpl implements DataSampleService {

    @Resource
    private DataSampleMapper dataSampleMapper;

    /**
     * Base64字符串转字节数组
     */
    private byte[] base64ToBytes(String base64Str) {
        if (!StringUtils.hasText(base64Str)) {
            return new byte[0];
        }
        return Base64.getDecoder().decode(base64Str.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 实体转换为VO工具方法
     */
    private DataSampleVO convertToVO(DataSample entity) {
        if (entity == null) {
            return null;
        }
        DataSampleVO vo = new DataSampleVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    @Override
    public DataSampleVO getByUuid(String uuid) {
        if (!StringUtils.hasText(uuid)) {
            return null;
        }
        DataSample sample = dataSampleMapper.selectByUuid(uuid);
        return convertToVO(sample);
    }

    @Override
    public List<DataSampleVO> listByDataPointUuid(String dataPointUuid) {
        if (!StringUtils.hasText(dataPointUuid)) {
            return Collections.emptyList();
        }
        List<DataSample> list = dataSampleMapper.listByDataPointUuid(dataPointUuid);
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public List<DataSampleVO> listByTaskUuid(String taskUuid) {
        if (!StringUtils.hasText(taskUuid)) {
            return Collections.emptyList();
        }
        List<DataSample> list = dataSampleMapper.listByTaskUuid(taskUuid);
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public boolean saveSample(DataSampleDTO dto) {
        try {
            DataSample entity = new DataSample();
            // 基础属性拷贝
            BeanUtils.copyProperties(dto, entity);
            // 生成UUID
            entity.setUuid(UUID.randomUUID().toString());
            // Base64转字节数组
            entity.setDataRecv(base64ToBytes(dto.getDataRecvBase64()));
            entity.setDataRecvPos(base64ToBytes(dto.getDataRecvPosBase64()));
            entity.setDataRecvLen(base64ToBytes(dto.getDataRecvLenBase64()));
            entity.setDataSend(base64ToBytes(dto.getDataSendBase64()));
            entity.setDataSoff(base64ToBytes(dto.getDataSoffBase64()));
            // 初始化逻辑删除标记
            entity.setIsDel(false);
            // 调用Mapper插入
            int rows = dataSampleMapper.insert(entity);
            log.info("新增采样数据成功，UUID:{}", entity.getUuid());
            return rows > 0;
        } catch (Exception e) {
            log.error("新增采样数据失败", e);
            return false;
        }
    }

    @Override
    public boolean updateSample(String uuid, DataSampleDTO dto) {
        if (!StringUtils.hasText(uuid) || dto == null) {
            log.warn("更新采样数据参数不合法，uuid:{}", uuid);
            return false;
        }
        try {
            DataSample entity = new DataSample();
            BeanUtils.copyProperties(dto, entity);
            // 设置更新条件
            entity.setUuid(uuid);
            // Base64转字节数组
            entity.setDataRecv(base64ToBytes(dto.getDataRecvBase64()));
            entity.setDataRecvPos(base64ToBytes(dto.getDataRecvPosBase64()));
            entity.setDataRecvLen(base64ToBytes(dto.getDataRecvLenBase64()));
            entity.setDataSend(base64ToBytes(dto.getDataSendBase64()));
            entity.setDataSoff(base64ToBytes(dto.getDataSoffBase64()));
            // 手动更新时间
            entity.setUpdateTime(LocalDateTime.now());

            int rows = dataSampleMapper.updateByUuid(entity);
            log.info("更新采样数据成功，UUID:{}，影响行数:{}", uuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("更新采样数据失败，UUID:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean deleteByUuid(String uuid, Long updateBy) {
        if (!StringUtils.hasText(uuid) || updateBy == null) {
            log.warn("删除采样数据参数不合法，uuid:{}, updateBy:{}", uuid, updateBy);
            return false;
        }
        try {
            int rows = dataSampleMapper.deleteByUuid(uuid, updateBy);
            log.info("逻辑删除采样数据成功，UUID:{}", uuid);
            return rows > 0;
        } catch (Exception e) {
            log.error("逻辑删除采样数据失败，UUID:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean batchDeleteByPointUuid(String dataPointUuid, Long updateBy) {
        if (!StringUtils.hasText(dataPointUuid) || updateBy == null) {
            log.warn("批量删除采样数据参数不合法，pointUuid:{}, updateBy:{}", dataPointUuid, updateBy);
            return false;
        }
        try {
            int rows = dataSampleMapper.batchDeleteByDataPointUuid(dataPointUuid, updateBy);
            log.info("批量逻辑删除采样数据成功，作业点UUID:{}，影响行数:{}", dataPointUuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("批量逻辑删除采样数据失败，作业点UUID:{}", dataPointUuid, e);
            return false;
        }
    }
}