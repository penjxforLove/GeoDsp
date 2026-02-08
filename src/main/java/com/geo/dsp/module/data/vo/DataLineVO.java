package com.geo.dsp.module.data.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 作业线信息返回VO
 */
@Data
public class DataLineVO {
    private String uuid;
    private String lineName;
    private Long engineeringId;
    private LocalDateTime planStartTime;
    private LocalDateTime planEndTime;
    private Integer status;
    private Long createBy;
    private LocalDateTime createTime;
    private Long updateBy;
    private LocalDateTime updateTime;
    private String note;
}