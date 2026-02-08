package com.geo.dsp.module.data.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 工程信息返回VO
 */
@Data
public class DataProjectVO {
    private String uuid;
    private Long projectId;
    private Long taskId;
    private String engineeringName;
    private String deviceNum;
    private String antennaNum;
    private Long operatorId;
    private String controlParams;
    private Integer status;
    private Long createBy;
    private LocalDateTime createTime;
    private Long updateBy;
    private LocalDateTime updateTime;
    private String note;
}