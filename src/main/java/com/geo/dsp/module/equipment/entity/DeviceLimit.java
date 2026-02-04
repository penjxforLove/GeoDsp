package com.geo.dsp.module.equipment.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 设备使用限制表实体
 * 对应表：geo_dsp_device_limit
 */
@Data
@TableName("geo_dsp_device_limit")
public class DeviceLimit {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 限额ID

    private String uuid;                // UUID，唯一标识

    private Long deviceId;              // 设备ID

    private LocalDateTime startTime;    // 开始时间

    private LocalDateTime endTime;      // 结束时间

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private String note;                // 备注

    private Boolean isDel;              // 是否删除
}