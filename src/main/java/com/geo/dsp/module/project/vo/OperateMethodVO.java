package com.geo.dsp.module.project.vo;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 作业方法 返回VO
 */
@Data
public class OperateMethodVO {
    private String uuid;
    private String methodName;
    private String methodDesc;
    private String note;
    private Long createBy;
    private LocalDateTime createTime;
    private Long updateBy;
    private LocalDateTime updateTime;
}