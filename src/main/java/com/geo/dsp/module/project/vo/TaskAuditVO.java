package com.geo.dsp.module.project.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 任务审核记录返回VO
 */
@Data
public class TaskAuditVO {
    private String uuid;
    private Long taskId;
    private Long simpleId;
    private Long auditorId;
    private LocalDateTime auditTime;
    private Integer auditResult;
    private String auditOpinion;
    private Long createBy;
    private LocalDateTime createTime;
}