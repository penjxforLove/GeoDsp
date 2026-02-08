package com.geo.dsp.module.project.service;

import com.geo.dsp.module.project.dto.TaskAuditDTO;
import com.geo.dsp.module.project.vo.TaskAuditVO;
import java.util.List;

public interface TaskAuditService {

    /**
     * 根据UUID查询审核记录详情
     */
    TaskAuditVO getByUuid(String uuid);

    /**
     * 根据任务UUID查询审核记录列表
     */
    List<TaskAuditVO> listByTaskUuid(String taskUuid);

    /**
     * 根据审核人UUID查询审核记录列表
     */
    List<TaskAuditVO> listByAuditorUuid(String auditorUuid);

    /**
     * 新增审核记录
     */
    boolean saveAuditRecord(TaskAuditDTO dto);

    /**
     * 根据UUID更新审核结果和意见
     */
    boolean updateAuditResult(String uuid, Integer auditResult, String auditOpinion);

    /**
     * 根据UUID逻辑删除审核记录
     */
    boolean deleteByUuid(String uuid);
}