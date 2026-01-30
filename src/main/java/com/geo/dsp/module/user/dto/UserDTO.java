package com.geo.dsp.module.user.dto;

import lombok.Data;

/**
 * 用户数据传输对象
 */
@Data
public class UserDTO {

    /**
     * 用户ID（更新时必填）
     */
    private Long id;

    /**
     * 用户名（必填）
     */
    private String username;

    /**
     * 密码（创建时必填）
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;
    public String getUsername() {
        return username;
    }

    public Object getId() {
        return id;
    }
}
