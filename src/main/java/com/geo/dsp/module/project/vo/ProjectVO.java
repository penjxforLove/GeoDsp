package com.geo.dsp.module.project.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 项目信息返回VO
 */
@Data
public class ProjectVO {
    private String uuid;
    private Long companyId;
    private String projectName;
    private LocalDateTime startTime;
    private LocalDateTime expectEndTime;
    private LocalDateTime actualEndTime;
    private Long operatorId;
    private Integer status;
    private Long createBy;
    private LocalDateTime createTime;
    private Long updateBy;
    private LocalDateTime updateTime;
    private String note;
}