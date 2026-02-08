package com.geo.dsp.module.data.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 采样数据返回VO
 */
@Data
public class DataSampleVO {
    private String uuid;
    private Integer use;
    private Long taskId;
    private Integer dataPointId;
    private Integer startTime;
    private Integer deviceType;
    private Integer type;
    private Integer period;
    private Float sendFs;
    private Float sampleSendFs;
    private Float sampleOffFs;
    private Float recvFs;
    private LocalDateTime createTime;
    private Long updateBy;
    private LocalDateTime updateTime;
    private String note;
}