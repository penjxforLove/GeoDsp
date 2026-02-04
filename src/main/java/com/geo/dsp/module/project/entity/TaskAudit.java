package com.geo.dsp.module.project.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 任务审核表实体
 * 对应表：geo_dsp_task_audit
 */
@Data
@TableName("geo_dsp_task_audit")
public class TaskAudit {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 审核ID

    private String uuid;                // UUID，唯一标识

    private Long taskId;                // 任务ID

    private Long simpleId;              // 简单ID（自增）

    private Long auditorId;             // 审核人ID

    private LocalDateTime auditTime;    // 审核时间

    private Integer auditResult;        // 审核结果（1-通过，2-驳回）

    private String auditOpinion;        // 审核意见

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Boolean isDel;              // 是否删除
}