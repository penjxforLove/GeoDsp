package com.geo.dsp.module.data.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 采样数据历史记录返回VO
 */
@Data
public class DataHistoryVO {
    private String uuid;
    private Long dataId;
    private String oldDataContent;
    private Integer operateType;
    private Long operateBy;
    private LocalDateTime operateTime;
}