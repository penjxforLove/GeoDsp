package com.geo.dsp.module.equipment.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 设备使用记录表实体
 * 对应表：geo_dsp_device_usage_record
 */
@Data
@TableName("geo_dsp_device_usage_record")
public class DeviceUsageRecord {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 记录ID

    private String uuid;                // UUID，唯一标识

    private Long deviceId;              // 设备ID

    private Long projectId;             // 项目ID

    private Long engineeringId;         // 工程ID

    private Long taskId;                // 任务ID

    private Long userId;                // 使用者ID

    private LocalDateTime useStartTime; // 使用开始时间

    private LocalDateTime useEndTime;   // 使用结束时间

    private String note;                // 备注

    private Boolean isDel;              // 是否删除
}