package com.geo.dsp.module.privilege.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 权限表实体
 * 对应表：geo_dsp_permissions
 */
@Data
@TableName("geo_dsp_permissions")
public class Permission {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 权限ID

    private String uuid;                // UUID，唯一标识

    private String permissionName;      // 权限名称

    private String permissionCode;      // 权限编码

    private String permissionDesc;      // 权限描述

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private Boolean isDel;              // 是否删除
}