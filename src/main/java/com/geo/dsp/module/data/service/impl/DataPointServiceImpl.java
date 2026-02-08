package com.geo.dsp.module.data.service.impl;

import com.geo.dsp.module.data.dto.DataPointDTO;
import com.geo.dsp.module.data.entity.DataPoint;
import com.geo.dsp.module.data.mapper.DataPointMapper;
import com.geo.dsp.module.data.service.DataPointService;
import com.geo.dsp.module.data.vo.DataPointVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DataPointServiceImpl implements DataPointService {

    @Resource
    private DataPointMapper dataPointMapper;

    /**
     * 实体转换为VO工具方法
     */
    private DataPointVO convertToVO(DataPoint entity) {
        if (entity == null) {
            return null;
        }
        DataPointVO vo = new DataPointVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    @Override
    public DataPointVO getByUuid(String uuid) {
        if (!StringUtils.hasText(uuid)) {
            return null;
        }
        DataPoint dataPoint = dataPointMapper.selectByUuid(uuid);
        return convertToVO(dataPoint);
    }

    @Override
    public List<DataPointVO> listByDataLineUuid(String dataLineUuid) {
        if (!StringUtils.hasText(dataLineUuid)) {
            return Collections.emptyList();
        }
        List<DataPoint> list = dataPointMapper.listByDataLineUuid(dataLineUuid);
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public boolean saveDataPoint(DataPointDTO dto) {
        try {
            DataPoint entity = new DataPoint();
            // 属性拷贝
            BeanUtils.copyProperties(dto, entity);
            // 填充系统自动生成字段
            entity.setUuid(UUID.randomUUID().toString());
            entity.setCreateBy(dto.getOperatorId());
            entity.setUpdateBy(dto.getOperatorId());
            entity.setCreateTime(LocalDateTime.now());
            entity.setUpdateTime(LocalDateTime.now());
            entity.setIsDel(false);

            int rows = dataPointMapper.insert(entity);
            log.info("新增采集点成功，UUID:{}", entity.getUuid());
            return rows > 0;
        } catch (Exception e) {
            log.error("新增采集点失败", e);
            return false;
        }
    }

    @Override
    public boolean updateDataPoint(String uuid, DataPointDTO dto) {
        if (!StringUtils.hasText(uuid) || dto == null) {
            log.warn("更新采集点参数不合法，uuid:{}", uuid);
            return false;
        }
        try {
            DataPoint entity = new DataPoint();
            BeanUtils.copyProperties(dto, entity);
            // 设置更新条件和系统字段
            entity.setUuid(uuid);
            entity.setUpdateBy(dto.getOperatorId());
            entity.setUpdateTime(LocalDateTime.now());

            int rows = dataPointMapper.updateByUuid(entity);
            log.info("更新采集点信息成功，UUID:{}，影响行数:{}", uuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("更新采集点信息失败，UUID:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean deleteByUuid(String uuid, Long updateBy) {
        if (!StringUtils.hasText(uuid) || updateBy == null) {
            log.warn("删除采集点参数不合法，uuid:{}, updateBy:{}", uuid, updateBy);
            return false;
        }
        try {
            int rows = dataPointMapper.deleteByUuid(uuid, updateBy);
            log.info("逻辑删除采集点成功，UUID:{}", uuid);
            return rows > 0;
        } catch (Exception e) {
            log.error("逻辑删除采集点失败，UUID:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean batchDeleteByLineUuid(String dataLineUuid, Long updateBy) {
        if (!StringUtils.hasText(dataLineUuid) || updateBy == null) {
            log.warn("批量删除采集点参数不合法，lineUuid:{}, updateBy:{}", dataLineUuid, updateBy);
            return false;
        }
        try {
            int rows = dataPointMapper.batchDeleteByDataLineUuid(dataLineUuid, updateBy);
            log.info("批量逻辑删除采集点成功，线路UUID:{}，影响行数:{}", dataLineUuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("批量逻辑删除采集点失败，线路UUID:{}", dataLineUuid, e);
            return false;
        }
    }
}