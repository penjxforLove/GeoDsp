package com.geo.dsp.module.data.controller;

import com.geo.dsp.common.result.Result;
import com.geo.dsp.module.data.dto.DataSampleDTO;
import com.geo.dsp.module.data.service.DataSampleService;
import com.geo.dsp.module.data.vo.DataSampleVO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/data/sample")
@Validated
public class DataSampleController {

    @Resource
    private DataSampleService dataSampleService;

    /**
     * 根据UUID查询采样数据基础信息
     */
    @GetMapping("/detail/{uuid}")
    public Result<DataSampleVO> getSampleByUuid(@PathVariable String uuid) {
        DataSampleVO vo = dataSampleService.getByUuid(uuid);
        return Result.success(vo);
    }

    /**
     * 根据作业点UUID查询采样数据列表
     */
    @GetMapping("/list/point/{dataPointUuid}")
    public Result<List<DataSampleVO>> listByPointUuid(@PathVariable String dataPointUuid) {
        List<DataSampleVO> list = dataSampleService.listByDataPointUuid(dataPointUuid);
        return Result.success(list);
    }

    /**
     * 根据任务UUID查询采样数据列表
     */
    @GetMapping("/list/task/{taskUuid}")
    public Result<List<DataSampleVO>> listByTaskUuid(@PathVariable String taskUuid) {
        List<DataSampleVO> list = dataSampleService.listByTaskUuid(taskUuid);
        return Result.success(list);
    }

    /**
     * 新增采样数据
     */
    @PostMapping("/save")
    public Result<Boolean> saveSample(@Validated @RequestBody DataSampleDTO dto) {
        boolean result = dataSampleService.saveSample(dto);
        return result ? Result.success(true) : Result.errorMsg("新增采样数据失败");
    }

    /**
     * 根据UUID更新采样数据
     */
    @PutMapping("/update/{uuid}")
    public Result<Boolean> updateSample(
            @PathVariable String uuid,
            @Validated @RequestBody DataSampleDTO dto) {
        boolean result = dataSampleService.updateSample(uuid, dto);
        return result ? Result.success(true) : Result.errorMsg("更新采样数据失败");
    }

    /**
     * 根据UUID逻辑删除采样数据
     */
    @DeleteMapping("/delete/{uuid}")
    public Result<Boolean> deleteSample(
            @PathVariable String uuid,
            @RequestParam Long updateBy) {
        boolean result = dataSampleService.deleteByUuid(uuid, updateBy);
        return result ? Result.success(true) : Result.errorMsg("删除采样数据失败");
    }

    /**
     * 根据作业点UUID批量逻辑删除采样数据
     */
    @DeleteMapping("/batch/delete/point/{dataPointUuid}")
    public Result<Boolean> batchDeleteByPoint(
            @PathVariable String dataPointUuid,
            @RequestParam Long updateBy) {
        boolean result = dataSampleService.batchDeleteByPointUuid(dataPointUuid, updateBy);
        return result ? Result.success(true) : Result.errorMsg("批量删除采样数据失败");
    }
}