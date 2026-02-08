package com.geo.dsp.module.data.dto;

import lombok.Data;

/**
 * 采集点信息入参DTO
 */
@Data
public class DataPointDTO {
    /**
     * 所属线路ID
     */
    private Long lineId;

    /**
     * 采集点序号
     */
    private Integer sequence;

    /**
     * 操作人ID（创建/更新人）
     */
    private Long operatorId;
}