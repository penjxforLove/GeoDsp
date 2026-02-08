package com.geo.dsp.module.data.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 作业线信息入参DTO
 */
@Data
public class DataLineDTO {
    /**
     * 线路名称
     */
    private String lineName;

    /**
     * 工程ID
     */
    private Long engineeringId;

    /**
     * 计划开始时间
     */
    private LocalDateTime planStartTime;

    /**
     * 计划结束时间
     */
    private LocalDateTime planEndTime;

    /**
     * 线路状态
     */
    private Integer status;

    /**
     * 操作人ID（创建/更新人）
     */
    private Long operatorId;

    /**
     * 备注信息
     */
    private String note;
}