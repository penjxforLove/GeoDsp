package com.geo.dsp.module.project.service.impl;

import com.geo.dsp.module.project.dto.OperationLogDTO;
import com.geo.dsp.module.project.entity.OperationLog;
import com.geo.dsp.module.project.mapper.OperationLogMapper;
import com.geo.dsp.module.project.service.OperationLogService;
import com.geo.dsp.module.project.vo.OperationLogVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Resource
    private OperationLogMapper operationLogMapper;

    /**
     * 实体对象 转换为 VO对象
     */
    private OperationLogVO convertToVO(OperationLog entity) {
        if (entity == null) {
            return null;
        }
        OperationLogVO vo = new OperationLogVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    @Override
    public OperationLogVO getByUuid(String uuid) {
        if (!StringUtils.hasText(uuid)) {
            return null;
        }
        OperationLog logEntity = operationLogMapper.selectByUuid(uuid);
        return convertToVO(logEntity);
    }

    @Override
    public List<OperationLogVO> listByProjectId(Long projectId) {
        if (projectId == null) {
            return Collections.emptyList();
        }
        List<OperationLog> list = operationLogMapper.listByProjectUuid(String.valueOf(projectId));
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public List<OperationLogVO> listByTaskId(Long taskId) {
        if (taskId == null) {
            return Collections.emptyList();
        }
        List<OperationLog> list = operationLogMapper.listByTaskUuid(String.valueOf(taskId));
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public List<OperationLogVO> listByLogDate(LocalDate logDate, Long creatorId) {
        if (logDate == null || creatorId == null) {
            return Collections.emptyList();
        }
        List<OperationLog> list = operationLogMapper.listByLogDate(logDate.toString(), creatorId);
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public boolean saveLog(OperationLogDTO dto) {
        try {
            OperationLog entity = new OperationLog();
            // 属性拷贝
            BeanUtils.copyProperties(dto, entity);
            // 填充必填字段
            entity.setUuid(UUID.randomUUID().toString());
            entity.setCreatorId(dto.getOperatorId());
            entity.setUpdateBy(dto.getOperatorId());
            entity.setCreateTime(LocalDateTime.now());
            entity.setUpdateTime(LocalDateTime.now());
            entity.setIsDel(false);
            // 执行插入
            int rows = operationLogMapper.insert(entity);
            log.info("新增作业日志成功，UUID:{}", entity.getUuid());
            return rows > 0;
        } catch (Exception e) {
            log.error("新增作业日志失败", e);
            return false;
        }
    }

    @Override
    public boolean updateContentByUuid(String uuid, String content, Long updateBy) {
        if (!StringUtils.hasText(uuid) || !StringUtils.hasText(content) || updateBy == null) {
            log.warn("更新作业日志参数不合法，uuid:{}, content:{}, updateBy:{}", uuid, content, updateBy);
            return false;
        }
        try {
            int rows = operationLogMapper.updateContentByUuid(uuid, content, updateBy);
            log.info("更新作业日志内容成功，UUID:{}，影响行数:{}", uuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("更新作业日志内容失败，UUID:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean deleteByUuid(String uuid, Long updateBy) {
        if (!StringUtils.hasText(uuid) || updateBy == null) {
            log.warn("删除作业日志参数不合法，uuid:{}, updateBy:{}", uuid, updateBy);
            return false;
        }
        try {
            int rows = operationLogMapper.deleteByUuid(uuid, updateBy);
            log.info("逻辑删除作业日志成功，UUID:{}，影响行数:{}", uuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("逻辑删除作业日志失败，UUID:{}", uuid, e);
            return false;
        }
    }
}