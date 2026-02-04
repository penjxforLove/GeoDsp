package com.geo.dsp.module.privilege.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 角色表实体
 * 对应表：geo_dsp_roles
 */
@Data
@TableName("geo_dsp_roles")
public class Role {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 角色ID

    private String uuid;                // UUID，唯一标识

    private Long companyId;             // 公司ID

    private String roleName;            // 角色名称

    private String roleDesc;            // 角色描述

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private Boolean isDel;              // 是否删除
}