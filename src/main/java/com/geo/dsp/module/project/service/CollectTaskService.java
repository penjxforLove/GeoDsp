package com.geo.dsp.module.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geo.dsp.module.project.dto.CollectTaskDTO;
import com.geo.dsp.module.project.entity.CollectTask;
import com.geo.dsp.module.project.vo.CollectTaskVO;

import java.util.List;

/**
 * 采集任务表 服务接口
 */
public interface CollectTaskService extends IService<CollectTask> {

    /**
     * 根据UUID查询任务详情
     *
     * @param uuid 任务UUID
     * @return 任务详情
     */
    CollectTaskVO getTaskByUuid(String uuid);

    /**
     * 根据项目UUID查询任务列表
     *
     * @param projectUuid 项目UUID
     * @return 任务列表
     */
    List<CollectTaskVO> listByProjectUuid(String projectUuid);

    /**
     * 根据操作员UUID查询任务列表
     *
     * @param operatorUuid 操作员UUID
     * @return 任务列表
     */
    List<CollectTaskVO> listByOperatorUuid(String operatorUuid);

    /**
     * 根据状态查询任务列表
     *
     * @param status 任务状态（0-未开始，1-进行中，2-已完成，3-审核中，4-已审核，5-驳回）
     * @return 任务列表
     */
    List<CollectTaskVO> listByStatus(Integer status);

    /**
     * 创建任务
     *
     * @param dto 任务信息
     * @return 创建结果
     */
    boolean createTask(CollectTaskDTO dto);

    /**
     * 更新任务
     *
     * @param uuid 任务UUID
     * @param dto 任务信息
     * @return 更新结果
     */
    boolean updateTask(String uuid, CollectTaskDTO dto);

    /**
     * 更新任务状态
     *
     * @param uuid 任务UUID
     * @param status 新状态
     * @param updateBy 修改人ID
     * @return 更新结果
     */
    boolean updateTaskStatus(String uuid, Integer status, Long updateBy);

    /**
     * 删除任务
     *
     * @param uuid 任务UUID
     * @param updateBy 修改人ID
     * @return 删除结果
     */
    boolean deleteTask(String uuid, Long updateBy);

    /**
     * 批量删除任务
     *
     * @param uuids 任务UUID列表
     * @param updateBy 修改人ID
     * @return 删除结果
     */
    boolean batchDeleteTask(List<String> uuids, Long updateBy);
}