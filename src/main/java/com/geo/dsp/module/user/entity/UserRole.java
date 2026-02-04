package com.geo.dsp.module.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 用户角色关联表实体
 * 对应表：geo_dsp_user_roles
 */
@Data
@TableName("geo_dsp_user_roles")
public class UserRole {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 关联ID

    private String uuid;                // UUID，唯一标识

    private Long companyId;             // 公司ID

    private Long userId;                // 用户ID

    private Long roleId;                // 角色ID

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private Boolean isDel;              // 是否删除

}