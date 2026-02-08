package com.geo.dsp.module.data.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 采集点信息返回VO
 */
@Data
public class DataPointVO {
    private String uuid;
    private Long lineId;
    private Integer sequence;
    private Long createBy;
    private LocalDateTime createTime;
    private Long updateBy;
    private LocalDateTime updateTime;
}