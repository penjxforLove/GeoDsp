package com.geo.dsp.module.data.controller;

import com.geo.dsp.common.result.Result;
import com.geo.dsp.module.data.dto.DataLineDTO;
import com.geo.dsp.module.data.service.DataLineService;
import com.geo.dsp.module.data.vo.DataLineVO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/data/line")
@Validated
public class DataLineController {

    @Resource
    private DataLineService dataLineService;

    /**
     * 根据UUID查询作业线详情
     */
    @GetMapping("/detail/{uuid}")
    public Result<DataLineVO> getLineByUuid(@PathVariable String uuid) {
        DataLineVO vo = dataLineService.getByUuid(uuid);
        return Result.success(vo);
    }

    /**
     * 根据工程UUID查询作业线列表
     */
    @GetMapping("/list/engineering/{engineeringUuid}")
    public Result<List<DataLineVO>> listByEngineeringUuid(@PathVariable String engineeringUuid) {
        List<DataLineVO> list = dataLineService.listByEngineeringUuid(engineeringUuid);
        return Result.success(list);
    }

    /**
     * 根据状态查询作业线列表
     */
    @GetMapping("/list/status/{status}")
    public Result<List<DataLineVO>> listByStatus(@PathVariable Integer status) {
        List<DataLineVO> list = dataLineService.listByStatus(status);
        return Result.success(list);
    }

    /**
     * 新增作业线
     */
    @PostMapping("/save")
    public Result<Boolean> saveDataLine(@Validated @RequestBody DataLineDTO dto) {
        boolean result = dataLineService.saveDataLine(dto);
        return result ? Result.success(true) : Result.errorMsg("新增作业线失败");
    }

    /**
     * 根据UUID更新作业线完整信息
     */
    @PutMapping("/update/{uuid}")
    public Result<Boolean> updateDataLine(
            @PathVariable String uuid,
            @Validated @RequestBody DataLineDTO dto) {
        boolean result = dataLineService.updateDataLine(uuid, dto);
        return result ? Result.success(true) : Result.errorMsg("更新作业线失败");
    }

    /**
     * 单独更新作业线状态
     */
    @PutMapping("/update/status")
    public Result<Boolean> updateLineStatus(
            @RequestParam String uuid,
            @RequestParam Integer status,
            @RequestParam Long updateBy) {
        boolean result = dataLineService.updateLineStatus(uuid, status, updateBy);
        return result ? Result.success(true) : Result.errorMsg("更新作业线状态失败");
    }

    /**
     * 根据UUID逻辑删除作业线
     */
    @DeleteMapping("/delete/{uuid}")
    public Result<Boolean> deleteLine(
            @PathVariable String uuid,
            @RequestParam Long updateBy) {
        boolean result = dataLineService.deleteByUuid(uuid, updateBy);
        return result ? Result.success(true) : Result.errorMsg("删除作业线失败");
    }

    /**
     * 根据工程UUID批量逻辑删除作业线
     */
    @DeleteMapping("/batch/delete/engineering/{engineeringUuid}")
    public Result<Boolean> batchDeleteByEngineering(
            @PathVariable String engineeringUuid,
            @RequestParam Long updateBy) {
        boolean result = dataLineService.batchDeleteByEngineeringUuid(engineeringUuid, updateBy);
        return result ? Result.success(true) : Result.errorMsg("批量删除作业线失败");
    }
}