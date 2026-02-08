package com.geo.dsp.module.data.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 采样数据表 实体类
 * 对应数据库表：data_sample
 */
@Data
@TableName("data_sample")
public class DataSample {

    /**
     * 自增主键
     * 对应字段：id，bigserial 自增类型
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 对外主键
     * 对应字段：uuid，唯一约束
     */
    @TableField("uuid")
    private String uuid;

    /**
     * 使用者
     * 对应字段：use
     */
    @TableField("`use`")
    private Integer use;

    /**
     * 采集任务ID
     * 对应字段：task_id，外键关联 collect_task.id
     */
    @TableField("task_id")
    private Long taskId;

    /**
     * 作业点ID
     * 对应字段：data_point_id，外键关联 operate_point.id
     */
    @TableField("data_point_id")
    private Integer dataPointId;

    /**
     * 采样开始时间
     * 对应字段：starttime
     */
    @TableField("starttime")
    private Integer startTime;

    /**
     * 设备类型
     * 对应字段：devicetype
     */
    @TableField("devicetype")
    private Integer deviceType;

    /**
     * 数据类型
     * 对应字段：type
     */
    @TableField("`type`")
    private Integer type;

    /**
     * 采样周期（ms）
     * 对应字段：period
     */
    @TableField("period")
    private Integer period;

    /**
     * 接收数据
     * 对应字段：data_recv，PostgreSQL blob 映射为 byte[]
     */
    @TableField("data_recv")
    private byte[] dataRecv;

    /**
     * 接收数据位置信息
     * 对应字段：data_recv_pos
     */
    @TableField("data_recv_pos")
    private byte[] dataRecvPos;

    /**
     * 接收数据长度
     * 对应字段：data_recv_len
     */
    @TableField("data_recv_len")
    private byte[] dataRecvLen;

    /**
     * 发射数据
     * 对应字段：data_send
     */
    @TableField("data_send")
    private byte[] dataSend;

    /**
     * 关断数据
     * 对应字段：data_soff
     */
    @TableField("data_soff")
    private byte[] dataSoff;

    /**
     * 发射采样率
     * 对应字段：sendfs，real 类型映射为 Float
     */
    @TableField("sendfs")
    private Float sendFs;

    /**
     * 采样发射率
     * 对应字段：samplesendfs
     */
    @TableField("samplesendfs")
    private Float sampleSendFs;

    /**
     * 采样关断率
     * 对应字段：sampleofffs
     */
    @TableField("sampleofffs")
    private Float sampleOffFs;

    /**
     * 接收采样率
     * 对应字段：recvfs
     */
    @TableField("recvfs")
    private Float recvFs;

    /**
     * 创建时间
     * 对应字段：create_time，timestamptz 类型，自动填充
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改人ID
     * 对应字段：update_by，外键关联 users.id
     */
    @TableField("update_by")
    private Long updateBy;

    /**
     * 修改时间
     * 对应字段：update_time，自动填充
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 备注
     * 对应字段：note
     */
    @TableField("note")
    private String note;

    /**
     * 删除标记
     * 对应字段：is_del，逻辑删除字段，默认值 false
     */
    @TableLogic
    @TableField(value = "is_del", fill = FieldFill.INSERT)
    private Boolean isDel;
}