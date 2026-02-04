package com.geo.dsp.module.login.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 登录日志表实体
 * 对应表：geo_dsp_login_log
 */
@Data
@TableName("geo_dsp_login_log")
public class LoginLog {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 日志ID

    private String uuid;                // UUID，唯一标识

    private Long userId;                // 用户ID

    private Long companyId;             // 公司ID

    private Integer operateType;        // 操作类型（1-登录，2-登出）

    private LocalDateTime operateTime;  // 操作时间

    private String ipAddress;           // IP地址

    private String userAgent;           // 用户代理（浏览器信息）

    private Boolean isDel;              // 是否删除
}