package com.geo.dsp.module.project.mapper;

import com.geo.dsp.module.project.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作业日志表Mapper接口
 * 表说明：每日作业情况记录，关联项目、工程和采集任务
 */
@Mapper
public interface OperationLogMapper {
    /**
     * 根据UUID查询作业日志
     * @param uuid 作业日志UUID
     * @return 作业日志实体
     */
    OperationLog selectByUuid(@Param("uuid") String uuid);

    /**
     * 根据项目UUID查询作业日志列表
     * @param projectUuid 项目UUID
     * @return 作业日志列表（未删除）
     */
    List<OperationLog> listByProjectUuid(@Param("projectUuid") String projectUuid);

    /**
     * 根据采集任务UUID查询作业日志列表
     * @param taskUuid 采集任务UUID
     * @return 作业日志列表（未删除）
     */
    List<OperationLog> listByTaskUuid(@Param("taskUuid") String taskUuid);

    /**
     * 根据日志日期查询作业日志
     * @param logDate 日志日期（格式：yyyy-MM-dd）
     * @param creatorId 创建人ID
     * @return 作业日志列表（未删除）
     */
    List<OperationLog> listByLogDate(@Param("logDate") String logDate, @Param("creatorId") Long creatorId);

    /**
     * 新增作业日志
     * @param operationLog 作业日志实体（含UUID）
     * @return 受影响行数
     */
    int insert(OperationLog operationLog);

    /**
     * 根据UUID更新作业日志内容
     * @param uuid 作业日志UUID
     * @param content 日志内容
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int updateContentByUuid(@Param("uuid") String uuid, @Param("content") String content, @Param("updateBy") Long updateBy);

    /**
     * 根据UUID逻辑删除作业日志
     * @param uuid 作业日志UUID
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int deleteByUuid(@Param("uuid") String uuid, @Param("updateBy") Long updateBy);
}