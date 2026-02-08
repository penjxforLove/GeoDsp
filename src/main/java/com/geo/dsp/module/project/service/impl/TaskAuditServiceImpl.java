package com.geo.dsp.module.project.service.impl;

import com.geo.dsp.module.project.dto.TaskAuditDTO;
import com.geo.dsp.module.project.entity.TaskAudit;
import com.geo.dsp.module.project.mapper.TaskAuditMapper;
import com.geo.dsp.module.project.service.TaskAuditService;
import com.geo.dsp.module.project.vo.TaskAuditVO;
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
public class TaskAuditServiceImpl implements TaskAuditService {

    @Resource
    private TaskAuditMapper taskAuditMapper;

    /**
     * 实体转换为VO工具方法
     */
    private TaskAuditVO convertToVO(TaskAudit entity) {
        if (entity == null) {
            return null;
        }
        TaskAuditVO vo = new TaskAuditVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    @Override
    public TaskAuditVO getByUuid(String uuid) {
        if (!StringUtils.hasText(uuid)) {
            return null;
        }
        TaskAudit audit = taskAuditMapper.selectByUuid(uuid);
        return convertToVO(audit);
    }

    @Override
    public List<TaskAuditVO> listByTaskUuid(String taskUuid) {
        if (!StringUtils.hasText(taskUuid)) {
            return Collections.emptyList();
        }
        List<TaskAudit> list = taskAuditMapper.listByTaskUuid(taskUuid);
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public List<TaskAuditVO> listByAuditorUuid(String auditorUuid) {
        if (!StringUtils.hasText(auditorUuid)) {
            return Collections.emptyList();
        }
        List<TaskAudit> list = taskAuditMapper.listByAuditorUuid(auditorUuid);
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public boolean saveAuditRecord(TaskAuditDTO dto) {
        try {
            TaskAudit entity = new TaskAudit();
            // 属性拷贝
            BeanUtils.copyProperties(dto, entity);
            // 填充系统字段
            entity.setUuid(UUID.randomUUID().toString());
            entity.setAuditTime(LocalDateTime.now());
            entity.setCreateTime(LocalDateTime.now());
            entity.setIsDel(false);

            int rows = taskAuditMapper.insert(entity);
            log.info("新增任务审核记录成功，UUID:{}", entity.getUuid());
            return rows > 0;
        } catch (Exception e) {
            log.error("新增任务审核记录失败", e);
            return false;
        }
    }

    @Override
    public boolean updateAuditResult(String uuid, Integer auditResult, String auditOpinion) {
        if (!StringUtils.hasText(uuid) || auditResult == null || !StringUtils.hasText(auditOpinion)) {
            log.warn("更新审核记录参数不合法，uuid:{}, result:{}, opinion:{}", uuid, auditResult, auditOpinion);
            return false;
        }
        try {
            int rows = taskAuditMapper.updateAuditResultByUuid(uuid, auditResult, auditOpinion);
            log.info("更新审核记录结果成功，UUID:{}，影响行数:{}", uuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("更新审核记录结果失败，UUID:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean deleteByUuid(String uuid) {
        if (!StringUtils.hasText(uuid)) {
            log.warn("删除审核记录参数不合法，uuid:{}", uuid);
            return false;
        }
        try {
            int rows = taskAuditMapper.deleteByUuid(uuid);
            log.info("逻辑删除审核记录成功，UUID:{}，影响行数:{}", uuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("逻辑删除审核记录失败，UUID:{}", uuid, e);
            return false;
        }
    }
}