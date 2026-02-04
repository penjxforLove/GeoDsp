package com.geo.dsp.module.equipment.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 设备类型表实体
 * 对应表：geo_dsp_device_type
 */
@Data
@TableName("geo_dsp_device_type")
public class DeviceType {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 设备类型ID

    private String uuid;                // UUID，唯一标识

    private String typeName;            // 类型名称

    private String typeDesc;            // 类型描述

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private Boolean isDel;              // 是否删除

    private String note;                // 备注

}