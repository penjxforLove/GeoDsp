package com.geo.dsp.module.project.mapper;

import com.geo.dsp.module.project.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目表Mapper接口
 * 表说明：物探项目管理主表，多租户隔离（关联企业）
 */
@Mapper
public interface ProjectMapper {
    /**
     * 根据UUID查询项目
     * @param uuid 项目UUID（对外主键）
     * @return 项目实体
     */
    Project selectByUuid(@Param("uuid") String uuid);

    /**
     * 根据企业UUID查询项目列表
     * @param companyUuid 企业UUID
     * @return 项目列表（未删除）
     */
    List<Project> listByCompanyUuid(@Param("companyUuid") String companyUuid);

    /**
     * 根据状态查询项目列表
     * @param status 项目状态（0-未开始，1-进行中，2-已完成，3-终止）
     * @return 项目列表（未删除）
     */
    List<Project> listByStatus(@Param("status") Integer status);

    /**
     * 新增项目
     * @param project 项目实体（含UUID）
     * @return 受影响行数
     */
    int insert(Project project);

    /**
     * 根据UUID更新项目
     * @param project 项目实体（含UUID，非空字段更新）
     * @return 受影响行数
     */
    int updateByUuid(Project project);

    /**
     * 根据UUID修改项目状态
     * @param uuid 项目UUID
     * @param status 目标状态
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int updateStatusByUuid(@Param("uuid") String uuid, @Param("status") Integer status, @Param("updateBy") Long updateBy);

    /**
     * 根据UUID逻辑删除项目
     * @param uuid 项目UUID
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int deleteByUuid(@Param("uuid") String uuid, @Param("updateBy") Long updateBy);
}