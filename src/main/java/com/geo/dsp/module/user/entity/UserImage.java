package com.geo.dsp.module.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 用户头像表实体
 * 对应表：geo_dsp_user_image
 */
@Data
@TableName("geo_dsp_user_image")
public class UserImage {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 头像ID

    private byte[] image;               // 头像二进制数据

    private Boolean isDel;              // 是否删除

}