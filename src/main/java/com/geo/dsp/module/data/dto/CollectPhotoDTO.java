package com.geo.dsp.module.data.dto;

import lombok.Data;

/**
 * 采集照片入参DTO
 */
@Data
public class CollectPhotoDTO {
    /**
     * 采样数据ID
     */
    private Long dataId;

    /**
     * 照片名称
     */
    private String photoName;

    /**
     * 照片二进制数据
     */
    private byte[] photoData;

    /**
     * 上传者ID
     */
    private Long uploadBy;
}