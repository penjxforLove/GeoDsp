package com.geo.dsp.module.data.service.impl;

import com.geo.dsp.module.data.dto.DataLineDTO;
import com.geo.dsp.module.data.entity.DataLine;
import com.geo.dsp.module.data.mapper.DataLineMapper;
import com.geo.dsp.module.data.service.DataLineService;
import com.geo.dsp.module.data.vo.DataLineVO;
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
public class DataLineServiceImpl implements DataLineService {

    @Resource
    private DataLineMapper dataLineMapper;

    /**
     * 实体转换为VO工具方法
     */
    private DataLineVO convertToVO(DataLine entity) {
        if (entity == null) {
            return null;
        }
        DataLineVO vo = new DataLineVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    @Override
    public DataLineVO getByUuid(String uuid) {
        if (!StringUtils.hasText(uuid)) {
            return null;
        }
        DataLine dataLine = dataLineMapper.selectByUuid(uuid);
        return convertToVO(dataLine);
    }

    @Override
    public List<DataLineVO> listByEngineeringUuid(String engineeringUuid) {
        if (!StringUtils.hasText(engineeringUuid)) {
            return Collections.emptyList();
        }
        List<DataLine> list = dataLineMapper.listByEngineeringUuid(engineeringUuid);
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public List<DataLineVO> listByStatus(Integer status) {
        if (status == null) {
            return Collections.emptyList();
        }
        List<DataLine> list = dataLineMapper.listByStatus(status);
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public boolean saveDataLine(DataLineDTO dto) {
        try {
            DataLine entity = new DataLine();
            // 属性拷贝
            BeanUtils.copyProperties(dto, entity);
            // 填充系统自动生成字段
            entity.setUuid(UUID.randomUUID().toString());
            entity.setCreateBy(dto.getOperatorId());
            entity.setUpdateBy(dto.getOperatorId());
            entity.setCreateTime(LocalDateTime.now());
            entity.setUpdateTime(LocalDateTime.now());
            // 初始化状态：未开始
            entity.setStatus(dto.getStatus() == null ? 0 : dto.getStatus());
            entity.setIsDel(false);

            int rows = dataLineMapper.insert(entity);
            log.info("新增作业线成功，UUID:{}", entity.getUuid());
            return rows > 0;
        } catch (Exception e) {
            log.error("新增作业线失败", e);
            return false;
        }
    }

    @Override
    public boolean updateDataLine(String uuid, DataLineDTO dto) {
        if (!StringUtils.hasText(uuid) || dto == null) {
            log.warn("更新作业线参数不合法，uuid:{}", uuid);
            return false;
        }
        try {
            DataLine entity = new DataLine();
            BeanUtils.copyProperties(dto, entity);
            // 设置更新条件和系统字段
            entity.setUuid(uuid);
            entity.setUpdateBy(dto.getOperatorId());
            entity.setUpdateTime(LocalDateTime.now());

            int rows = dataLineMapper.updateByUuid(entity);
            log.info("更新作业线信息成功，UUID:{}，影响行数:{}", uuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("更新作业线信息失败，UUID:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean updateLineStatus(String uuid, Integer status, Long updateBy) {
        if (!StringUtils.hasText(uuid) || status == null || updateBy == null) {
            log.warn("更新作业线状态参数不合法，uuid:{}, status:{}, updateBy:{}", uuid, status, updateBy);
            return false;
        }
        try {
            int rows = dataLineMapper.updateStatusByUuid(uuid, status, updateBy);
            log.info("更新作业线状态成功，UUID:{}，新状态:{}", uuid, status);
            return rows > 0;
        } catch (Exception e) {
            log.error("更新作业线状态失败，UUID:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean deleteByUuid(String uuid, Long updateBy) {
        if (!StringUtils.hasText(uuid) || updateBy == null) {
            log.warn("删除作业线参数不合法，uuid:{}, updateBy:{}", uuid, updateBy);
            return false;
        }
        try {
            int rows = dataLineMapper.deleteByUuid(uuid, updateBy);
            log.info("逻辑删除作业线成功，UUID:{}", uuid);
            return rows > 0;
        } catch (Exception e) {
            log.error("逻辑删除作业线失败，UUID:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean batchDeleteByEngineeringUuid(String engineeringUuid, Long updateBy) {
        if (!StringUtils.hasText(engineeringUuid) || updateBy == null) {
            log.warn("批量删除作业线参数不合法，engineeringUuid:{}, updateBy:{}", engineeringUuid, updateBy);
            return false;
        }
        try {
            int rows = dataLineMapper.batchDeleteByEngineeringUuid(engineeringUuid, updateBy);
            log.info("批量逻辑删除作业线成功，工程UUID:{}，影响行数:{}", engineeringUuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("批量逻辑删除作业线失败，工程UUID:{}", engineeringUuid, e);
            return false;
        }
    }
}