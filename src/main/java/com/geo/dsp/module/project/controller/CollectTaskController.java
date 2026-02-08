package com.geo.dsp.module.project.controller;

import com.geo.dsp.common.result.Result;
import com.geo.dsp.module.project.dto.CollectTaskDTO;
import com.geo.dsp.module.project.service.CollectTaskService;
import com.geo.dsp.module.project.vo.CollectTaskVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 采集任务 前端控制器
 */
@Slf4j
@RestController
@RequestMapping("/collection-task")
public class CollectTaskController {

    @Autowired
    private CollectTaskService collectionTaskService;

    /**
     * 根据UUID获取任务详情
     *
     * @param uuid 任务UUID
     * @return 任务详情
     */
    @GetMapping("/{uuid}")
    public Result<CollectTaskVO> getTaskByUuid(@PathVariable String uuid) {
        log.info("根据UUID获取采集任务详情，UUID：{}", uuid);

        CollectTaskVO taskVO = collectionTaskService.getTaskByUuid(uuid);
        if (taskVO == null) {
            log.warn("采集任务不存在，UUID：{}", uuid);
            return Result.success(null);
        }

        log.debug("获取任务详情成功，任务名称：{}", taskVO.getTaskName());
        return Result.success(taskVO);
    }

    /**
     * 根据项目UUID查询任务列表
     *
     * @param projectUuid 项目UUID
     * @return 任务列表
     */
    @GetMapping("/project/{projectUuid}")
    public Result<List> listByProjectUuid(@PathVariable String projectUuid) {
        log.info("根据项目UUID查询采集任务列表，项目UUID：{}", projectUuid);

        List<CollectTaskVO> tasks = collectionTaskService.listByProjectUuid(projectUuid);

        log.debug("查询任务列表成功，共{}个", tasks.size());
        return Result.success(tasks);
    }

    /**
     * 根据操作员UUID查询任务列表
     *
     * @param operatorUuid 操作员UUID
     * @return 任务列表
     */
    @GetMapping("/operator/{operatorUuid}")
    public Result<List<CollectTaskVO>> listByOperatorUuid(@PathVariable String operatorUuid) {
        log.info("根据操作员UUID查询采集任务列表，操作员UUID：{}", operatorUuid);

        List<CollectTaskVO> tasks = collectionTaskService.listByOperatorUuid(operatorUuid);

        log.debug("查询任务列表成功，共{}个", tasks.size());
        return Result.success(tasks);
    }

    /**
     * 根据状态查询任务列表
     *
     * @param status 任务状态（0-未开始，1-进行中，2-已完成，3-审核中，4-已审核，5-驳回）
     * @return 任务列表
     */
    @GetMapping("/status/{status}")
    public Result<List<CollectTaskVO>> listByStatus(@PathVariable Integer status) {
        log.info("根据状态查询采集任务列表，状态：{}", status);

        List<CollectTaskVO> tasks = collectionTaskService.listByStatus(status);

        log.debug("查询任务列表成功，共{}个", tasks.size());
        return Result.success(tasks);
    }

    /**
     * 创建任务
     *
     * @param dto 任务信息
     * @return 创建结果
     */
    @PostMapping("/create")
    public Result<Boolean> createTask(@Validated @RequestBody CollectTaskDTO dto) {
        log.info("创建采集任务，任务名称：{}", dto.getTaskName());

        boolean result = collectionTaskService.createTask(dto);

        if (result) {
            log.info("创建采集任务成功，任务名称：{}", dto.getTaskName());
            return Result.success(true);
        } else {
            log.warn("创建采集任务失败，任务名称：{}", dto.getTaskName());
            return Result.errorMsg("创建采集任务失败");
        }
    }

    /**
     * 更新任务
     *
     * @param uuid 任务UUID
     * @param dto 任务信息
     * @return 更新结果
     */
    @PutMapping("/{uuid}")
    public Result<Boolean> updateTask(
            @PathVariable String uuid,
            @Validated @RequestBody CollectTaskDTO dto) {
        log.info("根据UUID更新采集任务，UUID：{}", uuid);

        boolean result = collectionTaskService.updateTask(uuid, dto);

        if (result) {
            log.info("更新采集任务成功，UUID：{}", uuid);
            return Result.success(true);
        } else {
            log.warn("更新采集任务失败，UUID：{}", uuid);
            return Result.errorMsg("更新采集任务失败");
        }
    }

    /**
     * 更新任务状态
     *
     * @param uuid 任务UUID
     * @param status 新状态
     * @param updateBy 修改人ID
     * @return 更新结果
     */
    @PutMapping("/{uuid}/status/{status}")
    public Result<Boolean> updateTaskStatus(
            @PathVariable String uuid,
            @PathVariable Integer status,
            @RequestParam Long updateBy) {
        log.info("根据UUID更新采集任务状态，UUID：{}，状态：{}", uuid, status);

        boolean result = collectionTaskService.updateTaskStatus(uuid, status, updateBy);

        if (result) {
            log.info("更新采集任务状态成功，UUID：{}，状态：{}", uuid, status);
            return Result.success(true);
        } else {
            log.warn("更新采集任务状态失败，UUID：{}", uuid);
            return Result.errorMsg("更新采集任务状态失败");
        }
    }

    /**
     * 根据UUID删除任务
     *
     * @param uuid 任务UUID
     * @param updateBy 修改人ID
     * @return 删除结果
     */
    @DeleteMapping("/{uuid}")
    public Result<Boolean> deleteTask(
            @PathVariable String uuid,
            @RequestParam Long updateBy) {
        log.info("根据UUID删除采集任务，UUID：{}", uuid);

        boolean result = collectionTaskService.deleteTask(uuid, updateBy);

        if (result) {
            log.info("删除采集任务成功，UUID：{}", uuid);
            return Result.success(true);
        } else {
            log.warn("删除采集任务失败，UUID：{}", uuid);
            return Result.errorMsg("删除采集任务失败");
        }
    }

    /**
     * 批量删除任务
     *
     * @param request 包含UUID列表和修改人ID
     * @return 删除结果
     */
    @DeleteMapping("/batch")
    public Result<String> batchDeleteTask(@RequestBody BatchDeleteRequest request) {
        log.info("批量删除采集任务，UUID列表：{}", request.getUuids());

        boolean result = collectionTaskService.batchDeleteTask(request.getUuids(), request.getUpdateBy());

        if (result) {
            log.info("批量删除采集任务成功，共删除：{}个任务", request.getUuids().size());
            return Result.successMsg("批量删除采集任务成功");
        } else {
            log.warn("批量删除采集任务失败，UUID列表：{}", request.getUuids());
            return Result.error("批量删除采集任务失败");
        }
    }

    /**
     * 批量删除请求体
     */
    @lombok.Data
    public static class BatchDeleteRequest {
        /**
         * 任务UUID列表
         */
        private List<String> uuids;

        /**
         * 修改人ID
         */
        private Long updateBy;
    }
}