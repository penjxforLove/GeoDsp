package com.geo.dsp.module.equipment.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 设备表实体
 * 对应表：device
 */
@Data
@TableName("device")
public class Device {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 设备ID

    private String uuid;                // UUID，唯一标识

    private Long companyId;             // 所属公司ID

    private String deviceNum;           // 设备编号

    private Long deviceTypeId;          // 设备类型ID

    private String antennaNum;          // 天线号

    private Integer status;             // 状态（0-正常，1-使用中，2-故障）

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private String note;                // 备注

    private Boolean isDel;              // 是否删除
}