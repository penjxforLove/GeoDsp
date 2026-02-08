package com.geo.dsp.module.equipment.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.math.BigDecimal;

/**
 * 天线配置信息表实体
 * 对应表：data_workset
 *
 * 说明：存储天线/设备工作配置，包含发射线圈和接收线圈的物理参数
 */
@Data
@TableName("data_workset")
public class DataWorkset {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 配置ID

    private String uuid;                // UUID，唯一标识

    private Integer workConfig;         // 工作配置

    private BigDecimal sendcoilLen;     // 发射线圈长度

    private BigDecimal sendcoilWidth;   // 发射线圈宽度

    private BigDecimal sendcoilTurns;   // 发射线圈匝数

    private BigDecimal recvcoilSize;    // 接收线圈尺寸

    private BigDecimal recvcoilGain;    // 接收线圈增益

    private String note;                // 备注

    private Boolean isDel;              // 是否删除（默认false）
}