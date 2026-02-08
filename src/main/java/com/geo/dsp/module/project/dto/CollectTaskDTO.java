package com.geo.dsp.module.project.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 采集任务数据传输对象
 */
@Data
public class CollectTaskDTO {

    /**
     * 任务ID（更新时必填）
     */
    private Long id;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 作业方法ID
     */
    private Long methodId;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 预计结束时间
     */
    private LocalDateTime expectEndTime;

    /**
     * 操作员ID
     */
    private Long operatorId;

    /**
     * 任务状态（0-未开始，1-进行中，2-已完成，3-审核中，4-已审核，5-驳回）
     */
    private Integer status;

    /**
     * 备注
     */
    private String note;
}