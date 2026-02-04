package com.geo.dsp.module.privilege.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.math.BigDecimal;

/**
 * 字典表实体
 * 对应表：geo_dsp_dict
 */
@Data
@TableName("geo_dsp_dict")
public class Dict {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 字典ID

    private String uuid;                // UUID，唯一标识

    private String dictKey;             // 字典键（如：USER_STATUS）

    private String dictStrVal;          // 字典字符串值

    private BigDecimal dictNumVal;      // 字典数值

    private String dictDesc;            // 字典描述

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private Boolean isDel;              // 是否删除
}