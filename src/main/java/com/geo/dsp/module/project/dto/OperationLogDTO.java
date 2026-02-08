package com.geo.dsp.module.project.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class OperationLogDTO {
    // 项目ID
    private Long projectId;

    // 工程ID
    private Long engineeringId;

    // 采集任务ID
    private Long taskId;

    // 日志日期
    private LocalDate logDate;

    // 日志内容
    private String content;

    // 操作人ID（创建/更新人）
    private Long operatorId;
}