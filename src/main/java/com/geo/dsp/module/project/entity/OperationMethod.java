package com.geo.dsp.module.project.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 作业方法表实体
 * 对应表：geo_dsp_operation_method
 */
@Data
@TableName("geo_dsp_operation_method")
public class OperationMethod {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 方法ID

    private String uuid;                // UUID，唯一标识

    private String methodName;          // 方法名称

    private String methodDesc;          // 方法描述

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private Boolean isDel;              // 是否删除

    private String note;                // 备注
}
