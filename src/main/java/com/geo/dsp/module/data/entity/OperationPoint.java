package com.geo.dsp.module.data.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 作业点表实体
 * 对应表：geo_dsp_operation_point
 */
@Data
@TableName("geo_dsp_operation_point")
public class OperationPoint {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 采集点ID

    private String uuid;                // UUID，唯一标识

    private Long lineId;                // 线路ID

    private Integer sequence;           // 序号

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private Boolean isDel;              // 是否删除
}