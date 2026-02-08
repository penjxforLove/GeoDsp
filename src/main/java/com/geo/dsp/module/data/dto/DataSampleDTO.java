package com.geo.dsp.module.data.dto;

import lombok.Data;

/**
 * 采样数据入参DTO
 */
@Data
public class DataSampleDTO {
    /**
     * 使用者
     */
    private Integer use;

    /**
     * 采集任务ID
     */
    private Long taskId;

    /**
     * 作业点ID
     */
    private Integer dataPointId;

    /**
     * 采样开始时间戳
     */
    private Integer startTime;

    /**
     * 设备类型
     */
    private Integer deviceType;

    /**
     * 数据类型
     */
    private Integer type;

    /**
     * 采样周期(ms)
     */
    private Integer period;

    /**
     * 接收数据 Base64字符串
     */
    private String dataRecvBase64;

    /**
     * 接收数据位置信息 Base64字符串
     */
    private String dataRecvPosBase64;

    /**
     * 接收数据长度信息 Base64字符串
     */
    private String dataRecvLenBase64;

    /**
     * 发射数据 Base64字符串
     */
    private String dataSendBase64;

    /**
     * 关断数据 Base64字符串
     */
    private String dataSoffBase64;

    /**
     * 发射采样率
     */
    private Float sendFs;

    /**
     * 采样发射率
     */
    private Float sampleSendFs;

    /**
     * 采样关断率
     */
    private Float sampleOffFs;

    /**
     * 接收采样率
     */
    private Float recvFs;

    /**
     * 修改人ID
     */
    private Long updateBy;

    /**
     * 备注信息
     */
    private String note;
}