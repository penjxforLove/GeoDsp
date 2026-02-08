package com.geo.dsp.module.data.dto;

import lombok.Data;

/**
 * 采样数据历史记录入参DTO
 */
@Data
public class DataHistoryDTO {
    /**
     * 采样数据ID
     */
    private Long dataId;

    /**
     * 修改前的数据内容 JSON格式
     */
    private String oldDataContent;

    /**
     * 操作类型 1-新增 2-修改
     */
    private Integer operateType;

    /**
     * 操作者ID
     */
    private Long operateBy;
}