package com.geo.dsp.module.data.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 采集数据历史表实体
 * 对应表：geo_dsp_collection_data_history
 */
@Data
@TableName("geo_dsp_collection_data_history")
public class CollectionDataHistory {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 历史记录ID

    private String uuid;                // UUID，唯一标识

    private Long dataId;                // 采样数据ID

    private String oldDataContent;      // 修改前的数据（JSON）

    private Integer operateType;        // 操作类型（1-新增，2-修改）

    private Long operateBy;             // 操作者ID

    private LocalDateTime operateTime;  // 操作时间

    private Boolean isDel;              // 是否删除
}