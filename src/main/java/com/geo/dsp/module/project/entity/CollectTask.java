package com.geo.dsp.module.project.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 采集任务表实体
 * 对应表：collect_task
 */
@Data
@TableName("collect_task")
public class CollectTask {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 任务ID

    private String uuid;                // UUID，唯一标识

    private Long projectId;             // 项目ID

    private Long methodId;              // 方法ID

    private String taskName;            // 任务名称

    private LocalDateTime startTime;    // 开始时间

    private LocalDateTime expectEndTime;// 期望结束时间

    private LocalDateTime actualEndTime;// 实际结束时间

    private Long operatorId;            // 操作员ID

    private int status;                 // 任务状态 0=未开始, 1=进行中, 2=已完成, 3=审核中, 4=已审核, 5=驳回

    private Long createBy;              // 创建人ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 修改人ID

    private LocalDateTime updateTime;   // 修改时间

    private String note;                // 备注

    private Boolean isDel;              // 是否删除

}