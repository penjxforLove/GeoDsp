package com.geo.dsp.module.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户表实体
 * 对应表：geo_dsp_users
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("geo_dsp_users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;                    // 用户ID

    private String uuid;                // UUID，唯一标识

    private Long companyId;             // 所属公司ID

    private Integer userType;           // 用户类型（1-管理员，2-企业管理，3-采样员）

    private String userName;            // 用户名称（真实姓名）

    private String account;             // 账号（登录用户名）

    private String password;            // 密码（加密存储）

    private String phoneNum;            // 手机号

    private String email;               // 邮箱

    private Integer status;             // 状态（0-禁用，1-启用）

    private Long imageId;               // 头像ID

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private Boolean isDel;              // 是否删除（false-未删除，true-已删除）

    private String note;                // 备注


}