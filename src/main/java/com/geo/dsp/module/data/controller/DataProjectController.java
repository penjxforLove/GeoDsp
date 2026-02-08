package com.geo.dsp.module.data.controller;

import com.geo.dsp.common.result.Result;
import com.geo.dsp.module.data.dto.DataProjectDTO;
import com.geo.dsp.module.data.service.DataProjectService;
import com.geo.dsp.module.data.vo.DataProjectVO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/data/project")
@Validated
public class DataProjectController {

    @Resource
    private DataProjectService dataProjectService;

    /**
     * 根据UUID查询工程详情
     */
    @GetMapping("/detail/{uuid}")
    public Result<DataProjectVO> getProjectByUuid(@PathVariable String uuid) {
        DataProjectVO vo = dataProjectService.getByUuid(uuid);
        return Result.success(vo);
    }

    /**
     * 根据项目UUID查询工程列表
     */
    @GetMapping("/list/parent/{projectUuid}")
    public Result<List<DataProjectVO>> listByProjectUuid(@PathVariable String projectUuid) {
        List<DataProjectVO> list = dataProjectService.listByProjectUuid(projectUuid);
        return Result.success(list);
    }

    /**
     * 根据状态查询工程列表
     */
    @GetMapping("/list/status/{status}")
    public Result<List<DataProjectVO>> listByStatus(@PathVariable Integer status) {
        List<DataProjectVO> list = dataProjectService.listByStatus(status);
        return Result.success(list);
    }

    /**
     * 新增工程
     */
    @PostMapping("/save")
    public Result<Boolean> saveDataProject(@Validated @RequestBody DataProjectDTO dto) {
        boolean result = dataProjectService.saveDataProject(dto);
        return result ? Result.success(true) : Result.errorMsg("新增工程失败");
    }

    /**
     * 根据UUID更新工程完整信息
     */
    @PutMapping("/update/{uuid}")
    public Result<Boolean> updateDataProject(
            @PathVariable String uuid,
            @Validated @RequestBody DataProjectDTO dto) {
        boolean result = dataProjectService.updateDataProject(uuid, dto);
        return result ? Result.success(true) : Result.errorMsg("更新工程失败");
    }

    /**
     * 单独更新工程状态
     */
    @PutMapping("/update/status")
    public Result<Boolean> updateProjectStatus(
            @RequestParam String uuid,
            @RequestParam Integer status,
            @RequestParam Long updateBy) {
        boolean result = dataProjectService.updateProjectStatus(uuid, status, updateBy);
        return result ? Result.success(true) : Result.errorMsg("更新工程状态失败");
    }

    /**
     * 根据UUID逻辑删除工程
     */
    @DeleteMapping("/delete/{uuid}")
    public Result<Boolean> deleteProject(
            @PathVariable String uuid,
            @RequestParam Long updateBy) {
        boolean result = dataProjectService.deleteByUuid(uuid, updateBy);
        return result ? Result.success(true) : Result.errorMsg("删除工程失败");
    }
}