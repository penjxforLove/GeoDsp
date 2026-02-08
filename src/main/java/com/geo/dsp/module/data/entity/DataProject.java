package com.geo.dsp.module.data.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 项目工程表实体
 * 对应表：data_project
 */
@Data
@TableName("data_project")
public class DataProject {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 工程ID

    private String uuid;                // UUID，唯一标识

    private Long projectId;             // 项目ID

    private Long taskId;                // 任务ID

    private String engineeringName;     // 工程名称

    private String deviceNum;           // 设备编号

    private String antennaNum;          // 天线号

    private Long operatorId;            // 操作者ID

    private String controlParams;       // 控制参数（JSON）

    private Integer status;             // 状态（0-未开始，1-进行中，2-已完成）

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private Boolean isDel;              // 是否删除

    private String note;                // 备注
}