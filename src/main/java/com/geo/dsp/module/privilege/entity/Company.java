package com.geo.dsp.module.privilege.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 企业表实体
 * 对应表：geo_dsp_companies
 */
@Data
@TableName("geo_dsp_companies")
public class Company {

    @TableId(type = IdType.AUTO)
    private Long id;                    // 企业ID

    private String uuid;                // UUID，唯一标识

    private String companyName;         // 企业名称

    private String companyAbbr;         // 企业简称

    private Integer status;             // 状态（0-禁用，1-启用）

    private String contactName;         // 联系人名称

    private String contactPhone;        // 联系人电话

    private String contactEmail;        // 联系人邮箱

    private String address;             // 企业地址

    private String licenseNum;          // 营业执照号

    private Long createBy;              // 创建者ID

    private LocalDateTime createTime;   // 创建时间

    private Long updateBy;              // 更新者ID

    private LocalDateTime updateTime;   // 更新时间

    private String note;                // 备注

    private Boolean isDel;              // 是否删除
}