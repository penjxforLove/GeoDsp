package com.geo.dsp.module.project.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.*;

@Data
@TableName("operation_log")
public class OperationLog {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 日志ID

    private String uuid;                // UUID，唯一标识

    private Long projectId;             // 项目ID

    private Long engineeringId;         // 工程ID

    private Long taskId;                // 任务ID

    private LocalDate logDate;          // 日志日期

    private String content;             // 日志内容

    private Long creatorId;             // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private Boolean isDel;              // 是否删除
}