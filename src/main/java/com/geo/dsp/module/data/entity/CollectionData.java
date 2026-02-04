package com.geo.dsp.module.data.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 采样数据表实体
 * 对应表：geo_dsp_collection_data
 */
@Data
@TableName("geo_dsp_collection_data")
public class CollectionData {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 采样数据ID

    private String uuid;                // UUID，唯一标识

    private Long taskId;                // 任务ID

    private Long pointId;               // 采集点ID

    private String gpsPoints;           // GPS坐标点（JSON数组）

    private String dataContent;         // 采样数据内容（JSON）

    private String softwareVersion;     // 软件版本

    private LocalDateTime collectionTime;// 采集时间

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private Boolean isDel;              // 是否删除
}