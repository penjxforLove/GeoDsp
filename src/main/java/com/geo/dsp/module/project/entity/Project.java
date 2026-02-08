package com.geo.dsp.module.project.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 项目表实体
 * 对应表：project
 */
@Data
@TableName("project")
public class Project {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 项目ID

    private String uuid;                // UUID，唯一标识

    private Long companyId;             // 公司ID

    private String projectName;         // 项目名称

    private LocalDateTime startTime;    // 开始时间

    private LocalDateTime expectEndTime;// 期望结束时间

    private LocalDateTime actualEndTime;// 实际结束时间

    private Long operatorId;            // 操作者ID

    private Integer status;             // 状态（0-未开始，1-进行中，2-已完成，3-审核中，4-已审核，5-已驳回）

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private String note;                // 备注

    private Boolean isDel;              // 是否删除
}