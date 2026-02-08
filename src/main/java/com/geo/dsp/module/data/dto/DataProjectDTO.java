package com.geo.dsp.module.data.dto;

import lombok.Data;

/**
 * 工程信息入参DTO
 */
@Data
public class DataProjectDTO {
    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 任务ID
     */
    private Long taskId;

    /**
     * 工程名称
     */
    private String engineeringName;

    /**
     * 设备编号
     */
    private String deviceNum;

    /**
     * 天线号
     */
    private String antennaNum;

    /**
     * 操作者ID
     */
    private Long operatorId;

    /**
     * 控制参数 JSON格式
     */
    private String controlParams;

    /**
     * 工程状态
     */
    private Integer status;

    /**
     * 备注信息
     */
    private String note;
}