package com.geo.dsp.module.project.controller;

import com.geo.dsp.common.result.Result;
import com.geo.dsp.module.project.dto.OperateMethodDTO;
import com.geo.dsp.module.project.service.OperateMethodService;
import com.geo.dsp.module.project.vo.OperateMethodVO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/project/operate/method")
@Validated
public class OperateMethodController {

    @Resource
    private OperateMethodService operateMethodService;

    /**
     * 根据UUID查询作业方法详情
     */
    @GetMapping("/detail/{uuid}")
    public Result<OperateMethodVO> getMethodByUuid(@PathVariable String uuid) {
        OperateMethodVO vo = operateMethodService.getByUuid(uuid);
        return Result.success(vo);
    }

    /**
     * 查询所有作业方法列表
     */
    @GetMapping("/list/all")
    public Result<List<OperateMethodVO>> listAllMethods() {
        List<OperateMethodVO> list = operateMethodService.listAll();
        return Result.success(list);
    }

    /**
     * 根据方法名称查询作业方法
     */
    @GetMapping("/detail/name")
    public Result<OperateMethodVO> getMethodByName(@RequestParam String methodName) {
        OperateMethodVO vo = operateMethodService.getByName(methodName);
        return Result.success(vo);
    }

    /**
     * 新增作业方法
     */
    @PostMapping("/save")
    public Result<Boolean> saveMethod(@Validated @RequestBody OperateMethodDTO dto) {
        boolean result = operateMethodService.saveMethod(dto);
        return result ? Result.success(true) : Result.errorMsg("新增作业方法失败");
    }

    /**
     * 根据UUID更新作业方法
     */
    @PutMapping("/update/{uuid}")
    public Result<Boolean> updateMethod(
            @PathVariable String uuid,
            @Validated @RequestBody OperateMethodDTO dto) {
        boolean result = operateMethodService.updateMethod(uuid, dto);
        return result ? Result.success(true) : Result.errorMsg("更新作业方法失败");
    }

    /**
     * 逻辑删除作业方法
     */
    @DeleteMapping("/delete/{uuid}")
    public Result<Boolean> deleteMethod(
            @PathVariable String uuid,
            @RequestParam Long updateBy) {
        boolean result = operateMethodService.deleteByUuid(uuid, updateBy);
        return result ? Result.success(true) : Result.errorMsg("删除作业方法失败");
    }
}