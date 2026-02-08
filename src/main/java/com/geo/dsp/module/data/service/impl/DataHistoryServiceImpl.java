package com.geo.dsp.module.data.service.impl;

import com.geo.dsp.module.data.dto.DataHistoryDTO;
import com.geo.dsp.module.data.entity.DataHistory;
import com.geo.dsp.module.data.mapper.DataHistoryMapper;
import com.geo.dsp.module.data.service.DataHistoryService;
import com.geo.dsp.module.data.vo.DataHistoryVO;
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
public class DataHistoryServiceImpl implements DataHistoryService {

    @Resource
    private DataHistoryMapper dataHistoryMapper;

    /**
     * 实体转换为VO工具方法
     */
    private DataHistoryVO convertToVO(DataHistory entity) {
        if (entity == null) {
            return null;
        }
        DataHistoryVO vo = new DataHistoryVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    @Override
    public DataHistoryVO getByUuid(String uuid) {
        if (!StringUtils.hasText(uuid)) {
            return null;
        }
        DataHistory history = dataHistoryMapper.selectByUuid(uuid);
        return convertToVO(history);
    }

    @Override
    public List<DataHistoryVO> listByDataUuid(String dataUuid) {
        if (!StringUtils.hasText(dataUuid)) {
            return Collections.emptyList();
        }
        List<DataHistory> list = dataHistoryMapper.listByDataUuid(dataUuid);
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public boolean saveHistory(DataHistoryDTO dto) {
        try {
            DataHistory entity = new DataHistory();
            // 属性拷贝
            BeanUtils.copyProperties(dto, entity);
            // 自动填充系统字段
            entity.setUuid(UUID.randomUUID().toString());
            entity.setOperateTime(LocalDateTime.now());
            entity.setIsDel(false);

            int rows = dataHistoryMapper.insert(entity);
            log.info("新增采样数据历史记录成功，UUID:{}", entity.getUuid());
            return rows > 0;
        } catch (Exception e) {
            log.error("新增采样数据历史记录失败", e);
            return false;
        }
    }

    @Override
    public boolean deleteByUuid(String uuid, Long updateBy) {
        if (!StringUtils.hasText(uuid) || updateBy == null) {
            log.warn("删除历史记录参数不合法，uuid:{}, updateBy:{}", uuid, updateBy);
            return false;
        }
        try {
            int rows = dataHistoryMapper.deleteByUuid(uuid, updateBy);
            log.info("逻辑删除采样数据历史记录成功，UUID:{}", uuid);
            return rows > 0;
        } catch (Exception e) {
            log.error("逻辑删除采样数据历史记录失败，UUID:{}", uuid, e);
            return false;
        }
    }
}