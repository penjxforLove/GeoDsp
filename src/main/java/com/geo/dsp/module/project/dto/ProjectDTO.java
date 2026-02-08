package com.geo.dsp.module.project.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 项目信息入参DTO
 */
@Data
public class ProjectDTO {
    /**
     * 公司ID
     */
    private Long companyId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 期望结束时间
     */
    private LocalDateTime expectEndTime;

    /**
     * 实际结束时间
     */
    private LocalDateTime actualEndTime;

    /**
     * 操作者ID
     */
    private Long operatorId;

    /**
     * 项目状态
     */
    private Integer status;

    /**
     * 备注信息
     */
    private String note;
}