package com.geo.dsp.module.project.mapper;

import com.geo.dsp.module.project.entity.TaskAudit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 任务审核表Mapper接口
 * 表说明：采集任务审核记录，关联任务和审核人
 */
@Mapper
public interface TaskAuditMapper {
    /**
     * 根据UUID查询审核记录
     * @param uuid 审核记录UUID
     * @return 审核记录实体
     */
    TaskAudit selectByUuid(@Param("uuid") String uuid);

    /**
     * 根据采集任务UUID查询审核记录列表
     * @param taskUuid 采集任务UUID
     * @return 审核记录列表（未删除）
     */
    List<TaskAudit> listByTaskUuid(@Param("taskUuid") String taskUuid);

    /**
     * 根据审核人UUID查询审核记录列表
     * @param auditorUuid 审核人UUID
     * @return 审核记录列表（未删除）
     */
    List<TaskAudit> listByAuditorUuid(@Param("auditorUuid") String auditorUuid);

    /**
     * 新增审核记录
     * @param taskAudit 审核记录实体（含UUID）
     * @return 受影响行数
     */
    int insert(TaskAudit taskAudit);

    /**
     * 根据UUID更新审核结果
     * @param uuid 审核记录UUID
     * @param auditResult 审核结果（1-通过，2-驳回）
     * @param auditOpinion 审核意见
     * @return 受影响行数
     */
    int updateAuditResultByUuid(@Param("uuid") String uuid, @Param("auditResult") Integer auditResult, @Param("auditOpinion") String auditOpinion);

    /**
     * 根据UUID逻辑删除审核记录
     * @param uuid 审核记录UUID
     * @return 受影响行数
     */
    int deleteByUuid(@Param("uuid") String uuid);
}