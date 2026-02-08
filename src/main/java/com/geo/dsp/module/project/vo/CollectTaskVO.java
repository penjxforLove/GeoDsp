package com.geo.dsp.module.project.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 采集任务视图对象
 */
@Data
public class CollectTaskVO {

    /**
     * 任务ID
     */
    private Long id;

    /**
     * UUID，唯一标识
     */
    private String uuid;

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
     * 实际结束时间
     */
    private LocalDateTime actualEnTime;

    /**
     * 操作员ID
     */
    private Long operatorId;

    /**
     * 任务状态（0-未开始，1-进行中，2-已完成，3-审核中，4-已审核，5-驳回）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String note;
}