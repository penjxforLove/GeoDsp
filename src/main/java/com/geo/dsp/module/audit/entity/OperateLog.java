package com.geo.dsp.module.audit.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 操作日志表实体
 * 对应表：geo_dsp_operate_log
 */
@Data
@TableName("geo_dsp_operate_log")
public class OperateLog {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 日志ID

    private String uuid;                // UUID，唯一标识

    private Long userId;                // 操作者ID

    private Long companyId;             // 公司ID

    private String moduleName;          // 操作模块（用户管理、设备管理等）

    private String operateType;         // 操作类型（新增、修改、删除等）

    private String operateDesc;         // 操作描述

    private LocalDateTime operateTime;  // 操作时间

    private String operateRecord;       // 操作前的记录（JSON）

    private String newRecord;           // 操作后的记录（JSON）

    private Boolean isDel;              // 是否删除
}