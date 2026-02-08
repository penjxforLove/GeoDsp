package com.geo.dsp.module.project.vo;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class OperationLogVO {
    private String uuid;
    private Long projectId;
    private Long engineeringId;
    private Long taskId;
    private LocalDate logDate;
    private String content;
    private Long creatorId;
    private LocalDateTime createTime;
    private Long updateBy;
    private LocalDateTime updateTime;
}