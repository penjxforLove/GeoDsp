package com.geo.dsp.module.user.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户视图对象
 */
@Data
public class UserVO {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public void setUpdateTime(LocalDateTime updateTime) {
    }

    public Throwable getUsername() {
        return null;
    }
    public void setUsername(String username) {
    }
    public void setRealName(String realName) {
    }
    public void setEmail(String email) {
    }
    public void setPhone(String phone) {
    }
    public void setStatus(Integer status) {
    }
    public void setCreateTime(LocalDateTime createTime) {
    }
    public void setId(Long id) {
    }
}