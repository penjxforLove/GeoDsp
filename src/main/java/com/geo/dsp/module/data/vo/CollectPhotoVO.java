package com.geo.dsp.module.data.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 采集照片返回VO
 */
@Data
public class CollectPhotoVO {
    private String uuid;
    private Long dataId;
    private String photoName;
    private LocalDateTime uploadTime;
    private Long uploadBy;
}