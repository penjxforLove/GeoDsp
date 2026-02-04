package com.geo.dsp.module.data.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 采集照片表实体
 * 对应表：collect_photo
 */
@Data
@TableName("collect_photo")
public class CollectPhoto {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 照片ID

    private String uuid;                // UUID，唯一标识

    private Long dataId;                // 采样数据ID

    private String photoName;           // 照片名称

    private byte[] photoData;           // 照片二进制数据

    private LocalDateTime uploadTime;   // 上传时间

    private Long uploadBy;              // 上传者ID

    private Boolean isDel;              // 是否删除
}