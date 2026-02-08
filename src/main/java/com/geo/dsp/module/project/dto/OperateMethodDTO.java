package com.geo.dsp.module.project.dto;

import lombok.Data;

/**
 * 作业方法 入参DTO
 */
@Data
public class OperateMethodDTO {
    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 方法描述
     */
    private String methodDesc;

    /**
     * 备注
     */
    private String note;

    /**
     * 操作人ID（创建/更新人）
     */
    private Long operatorId;
}