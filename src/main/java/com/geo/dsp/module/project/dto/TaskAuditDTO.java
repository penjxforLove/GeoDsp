package com.geo.dsp.module.project.dto;

import lombok.Data;

/**
 * 任务审核记录入参DTO
 */
@Data
public class TaskAuditDTO {
    /**
     * 任务ID
     */
    private Long taskId;

    /**
     * 简单ID
     */
    private Long simpleId;

    /**
     * 审核人ID
     */
    private Long auditorId;

    /**
     * 审核结果 1-通过 2-驳回
     */
    private Integer auditResult;

    /**
     * 审核意见
     */
    private String auditOpinion;

    /**
     * 创建人ID
     */
    private Long createBy;
}