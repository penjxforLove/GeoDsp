package com.geo.dsp.module.project.controller;

import com.geo.dsp.common.result.Result;
import com.geo.dsp.module.project.dto.ProjectDTO;
import com.geo.dsp.module.project.service.ProjectService;
import com.geo.dsp.module.project.vo.ProjectVO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/project")
@Validated
public class ProjectController {

    @Resource
    private ProjectService projectService;

    /**
     * 根据UUID查询项目详情
     */
    @GetMapping("/detail/{uuid}")
    public Result<ProjectVO> getProjectByUuid(@PathVariable String uuid) {
        ProjectVO projectVO = projectService.getProjectByUuid(uuid);
        return Result.success(projectVO);
    }

    /**
     * 根据企业UUID查询项目列表
     */
    @GetMapping("/list/company/{companyUuid}")
    public Result<List<ProjectVO>> listByCompanyUuid(@PathVariable String companyUuid) {
        List<ProjectVO> list = projectService.listByCompanyUuid(companyUuid);
        return Result.success(list);
    }

    /**
     * 根据状态查询项目列表
     */
    @GetMapping("/list/status/{status}")
    public Result<List<ProjectVO>> listByStatus(@PathVariable Integer status) {
        List<ProjectVO> list = projectService.listByStatus(status);
        return Result.success(list);
    }

    /**
     * 新增项目
     */
    @PostMapping("/save")
    public Result<Boolean> saveProject(@Validated @RequestBody ProjectDTO dto) {
        boolean result = projectService.saveProject(dto);
        return result ? Result.success(true) : Result.errorMsg("新增项目失败");
    }

    /**
     * 根据UUID更新项目完整信息
     */
    @PutMapping("/update/{uuid}")
    public Result<Boolean> updateProject(
            @PathVariable String uuid,
            @Validated @RequestBody ProjectDTO dto) {
        boolean result = projectService.updateProject(uuid, dto);
        return result ? Result.success(true) : Result.errorMsg("更新项目失败");
    }

    /**
     * 单独更新项目状态
     */
    @PutMapping("/update/status")
    public Result<Boolean> updateProjectStatus(
            @RequestParam String uuid,
            @RequestParam Integer status,
            @RequestParam Long updateBy) {
        boolean result = projectService.updateProjectStatus(uuid, status, updateBy);
        return result ? Result.success(true) : Result.errorMsg("更新项目状态失败");
    }

    /**
     * 逻辑删除项目
     */
    @DeleteMapping("/delete/{uuid}")
    public Result<Boolean> deleteProject(
            @PathVariable String uuid,
            @RequestParam Long updateBy) {
        boolean result = projectService.deleteProject(uuid, updateBy);
        return result ? Result.success(true) : Result.errorMsg("删除项目失败");
    }
}