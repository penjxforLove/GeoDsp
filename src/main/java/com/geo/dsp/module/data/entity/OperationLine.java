package com.geo.dsp.module.data.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 作业线表实体
 * 对应表：geo_dsp_operation_line
 */
@Data
@TableName("geo_dsp_operation_line")
public class OperationLine {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 线路ID

    private String uuid;                // UUID，唯一标识

    private String lineName;            // 线路名称

    private Long engineeringId;         // 工程ID

    private LocalDateTime planStartTime;// 计划开始时间

    private LocalDateTime planEndTime;  // 计划结束时间

    private Integer status;             // 状态（0-未开始，1-进行中，2-已完成，3-审核中，4-已审核）

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private String note;                // 备注

    private Boolean isDel;              // 是否删除
}