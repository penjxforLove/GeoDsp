package com.geo.dsp.module.project.mapper;

import com.geo.dsp.module.project.entity.CollectTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 采集任务表Mapper接
 * 表说明：具体的采集任务单，关联项目和作业方法
 */
@Mapper
public interface CollectTaskMapper {
    /**
     * 根据UUID查询采集任务
     * @param uuid 采集任务UUID
     * @return 采集任务实体
     */
    CollectTask selectByUuid(@Param("uuid") String uuid);

    /**
     * 根据项目UUID查询采集任务列表
     * @param projectUuid 项目UUID
     * @return 采集任务列表（未删除）
     */
    List<CollectTask> listByProjectUuid(@Param("projectUuid") String projectUuid);

    /**
     * 根据操作员UUID查询采集任务列表
     * @param operatorUuid 操作员UUID
     * @return 采集任务列表（未删除）
     */
    List<CollectTask> listByOperatorUuid(@Param("operatorUuid") String operatorUuid);

    /**
     * 根据状态查询采集任务列表
     * @param status 任务状态（0-未开始，1-进行中，2-已完成，3-审核中，4-已审核，5-驳回）
     * @return 采集任务列表（未删除）
     */
    List<CollectTask> listByStatus(@Param("status") Integer status);

    /**
     * 新增采集任务
     * @param collectTask 采集任务实体（含UUID）
     * @return 受影响行数
     */
    int insert(CollectTask collectTask);

    /**
     * 根据UUID更新采集任务
     * @param collectTask 采集任务实体（含UUID，非空字段更新）
     * @return 受影响行数
     */
    int updateByUuid(CollectTask collectTask);

    /**
     * 根据UUID修改采集任务状态
     * @param uuid 采集任务UUID
     * @param status 目标状态
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int updateStatusByUuid(@Param("uuid") String uuid, @Param("status") Integer status, @Param("updateBy") Long updateBy);

    /**
     * 根据UUID逻辑删除采集任务
     * @param uuid 采集任务UUID
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int deleteByUuid(@Param("uuid") String uuid, @Param("updateBy") Long updateBy);
}