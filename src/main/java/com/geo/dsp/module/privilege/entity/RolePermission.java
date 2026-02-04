package com.geo.dsp.module.privilege.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 角色权限关联表实体
 * 对应表：geo_dsp_role_permissions
 */
@Data
@TableName("geo_dsp_role_permissions")
public class RolePermission {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 关联ID

    private String uuid;                // UUID，唯一标识

    private Long companyId;             // 公司ID

    private Long roleId;                // 角色ID

    private Long permissionId;          // 权限ID

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private Boolean isDel;              // 是否删除

}