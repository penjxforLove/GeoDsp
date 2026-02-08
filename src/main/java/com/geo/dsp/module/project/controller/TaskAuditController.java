package com.geo.dsp.module.project.controller;

import com.geo.dsp.common.result.Result;
import com.geo.dsp.module.project.dto.TaskAuditDTO;
import com.geo.dsp.module.project.service.TaskAuditService;
import com.geo.dsp.module.project.vo.TaskAuditVO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/project/task/audit")
@Validated
public class TaskAuditController {

    @Resource
    private TaskAuditService taskAuditService;

    /**
     * 根据UUID查询审核记录详情
     */
    @GetMapping("/detail/{uuid}")
    public Result<TaskAuditVO> getAuditByUuid(@PathVariable String uuid) {
        TaskAuditVO vo = taskAuditService.getByUuid(uuid);
        return Result.success(vo);
    }

    /**
     * 根据任务UUID查询审核记录列表
     */
    @GetMapping("/list/task/{taskUuid}")
    public Result<List<TaskAuditVO>> listByTaskUuid(@PathVariable String taskUuid) {
        List<TaskAuditVO> list = taskAuditService.listByTaskUuid(taskUuid);
        return Result.success(list);
    }

    /**
     * 根据审核人UUID查询审核记录列表
     */
    @GetMapping("/list/auditor/{auditorUuid}")
    public Result<List<TaskAuditVO>> listByAuditorUuid(@PathVariable String auditorUuid) {
        List<TaskAuditVO> list = taskAuditService.listByAuditorUuid(auditorUuid);
        return Result.success(list);
    }

    /**
     * 新增任务审核记录
     */
    @PostMapping("/save")
    public Result<Boolean> saveAuditRecord(@Validated @RequestBody TaskAuditDTO dto) {
        boolean result = taskAuditService.saveAuditRecord(dto);
        return result ? Result.success(true) : Result.errorMsg("新增审核记录失败");
    }

    /**
     * 更新审核结果和意见
     */
    @PutMapping("/update/result")
    public Result<Boolean> updateAuditResult(
            @RequestParam String uuid,
            @RequestParam Integer auditResult,
            @RequestParam String auditOpinion) {
        boolean result = taskAuditService.updateAuditResult(uuid, auditResult, auditOpinion);
        return result ? Result.success(true) : Result.errorMsg("更新审核结果失败");
    }

    /**
     * 逻辑删除审核记录
     */
    @DeleteMapping("/delete/{uuid}")
    public Result<Boolean> deleteAuditRecord(@PathVariable String uuid) {
        boolean result = taskAuditService.deleteByUuid(uuid);
        return result ? Result.success(true) : Result.errorMsg("删除审核记录失败");
    }
}