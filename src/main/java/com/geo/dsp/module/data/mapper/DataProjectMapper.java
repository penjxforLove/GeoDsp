package com.geo.dsp.module.data.mapper;

import com.geo.dsp.module.data.entity.DataProject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 工程表Mapper接口
 * 表说明：一个项目包含多个工程，每个工程归属唯一项目
 */
@Mapper
public interface DataProjectMapper {
    /**
     * 根据UUID查询工程
     * @param uuid 工程UUID（对外主键）
     * @return 工程实体
     */
    DataProject selectByUuid(@Param("uuid") String uuid);

    /**
     * 根据项目UUID查询工程列表
     * @param projectUuid 项目UUID
     * @return 工程列表（未删除）
     */
    List<DataProject> listByProjectUuid(@Param("projectUuid") String projectUuid);

    /**
     * 根据状态查询工程列表
     * @param status 工程状态（0-未开始，1-进行中，2-已完成）
     * @return 工程列表（未删除）
     */
    List<DataProject> listByStatus(@Param("status") Integer status);

    /**
     * 新增工程
     * @param dataProject 工程实体（含UUID）
     * @return 受影响行数
     */
    int insert(DataProject dataProject);

    /**
     * 根据UUID更新工程
     * @param dataProject 工程实体（含UUID，非空字段更新）
     * @return 受影响行数
     */
    int updateByUuid(DataProject dataProject);

    /**
     * 根据UUID修改工程状态
     * @param uuid 工程UUID
     * @param status 目标状态
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int updateStatusByUuid(@Param("uuid") String uuid, @Param("status") Integer status, @Param("updateBy") Long updateBy);

    /**
     * 根据UUID逻辑删除工程
     * @param uuid 工程UUID
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int deleteByUuid(@Param("uuid") String uuid, @Param("updateBy") Long updateBy);
}