package com.geo.dsp.module.project.controller;

import com.geo.dsp.common.result.Result;
import com.geo.dsp.module.project.dto.OperationLogDTO;
import com.geo.dsp.module.project.service.OperationLogService;
import com.geo.dsp.module.project.vo.OperationLogVO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/project/operation/log")
@Validated
public class OperationLogController {

    @Resource
    private OperationLogService operationLogService;

    /**
     * 根据UUID查询单条日志
     */
    @GetMapping("/detail/{uuid}")
    public Result<OperationLogVO> getLogByUuid(@PathVariable String uuid) {
        OperationLogVO vo = operationLogService.getByUuid(uuid);
        return Result.success(vo);
    }

    /**
     * 根据项目ID查询日志列表
     */
    @GetMapping("/list/project/{projectId}")
    public Result<List<OperationLogVO>> listByProjectId(@PathVariable Long projectId) {
        List<OperationLogVO> list = operationLogService.listByProjectId(projectId);
        return Result.success(list);
    }

    /**
     * 根据任务ID查询日志列表
     */
    @GetMapping("/list/task/{taskId}")
    public Result<List<OperationLogVO>> listByTaskId(@PathVariable Long taskId) {
        List<OperationLogVO> list = operationLogService.listByTaskId(taskId);
        return Result.success(list);
    }

    /**
     * 根据日期+创建人查询日志列表
     */
    @GetMapping("/list/date")
    public Result<List<OperationLogVO>> listByDate(
            @RequestParam LocalDate logDate,
            @RequestParam Long creatorId) {
        List<OperationLogVO> list = operationLogService.listByLogDate(logDate, creatorId);
        return Result.success(list);
    }

    /**
     * 新增作业日志
     */
    @PostMapping("/save")
    public Result<Boolean> saveLog(@Validated @RequestBody OperationLogDTO dto) {
        boolean result = operationLogService.saveLog(dto);
        return result ? Result.success(true) : Result.errorMsg("新增日志失败");
    }

    /**
     * 根据UUID更新日志内容
     */
    @PutMapping("/update/content")
    public Result<Boolean> updateContent(
            @RequestParam String uuid,
            @RequestParam String content,
            @RequestParam Long updateBy) {
        boolean result = operationLogService.updateContentByUuid(uuid, content, updateBy);
        return result ? Result.success(true) : Result.errorMsg("更新日志失败");
    }

    /**
     * 逻辑删除日志
     */
    @DeleteMapping("/delete/{uuid}")
    public Result<Boolean> deleteLog(
            @PathVariable String uuid,
            @RequestParam Long updateBy) {
        boolean result = operationLogService.deleteByUuid(uuid, updateBy);
        return result ? Result.success(true) : Result.errorMsg("删除日志失败");
    }
}