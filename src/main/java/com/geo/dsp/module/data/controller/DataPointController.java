package com.geo.dsp.module.data.controller;

import com.geo.dsp.common.result.Result;
import com.geo.dsp.module.data.dto.DataPointDTO;
import com.geo.dsp.module.data.service.DataPointService;
import com.geo.dsp.module.data.vo.DataPointVO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/data/point")
@Validated
public class DataPointController {

    @Resource
    private DataPointService dataPointService;

    /**
     * 根据UUID查询采集点详情
     */
    @GetMapping("/detail/{uuid}")
    public Result<DataPointVO> getPointByUuid(@PathVariable String uuid) {
        DataPointVO vo = dataPointService.getByUuid(uuid);
        return Result.success(vo);
    }

    /**
     * 根据作业线UUID查询采集点列表
     */
    @GetMapping("/list/line/{dataLineUuid}")
    public Result<List<DataPointVO>> listByLineUuid(@PathVariable String dataLineUuid) {
        List<DataPointVO> list = dataPointService.listByDataLineUuid(dataLineUuid);
        return Result.success(list);
    }

    /**
     * 新增采集点
     */
    @PostMapping("/save")
    public Result<Boolean> saveDataPoint(@Validated @RequestBody DataPointDTO dto) {
        boolean result = dataPointService.saveDataPoint(dto);
        return result ? Result.success(true) : Result.errorMsg("新增采集点失败");
    }

    /**
     * 根据UUID更新采集点信息
     */
    @PutMapping("/update/{uuid}")
    public Result<Boolean> updateDataPoint(
            @PathVariable String uuid,
            @Validated @RequestBody DataPointDTO dto) {
        boolean result = dataPointService.updateDataPoint(uuid, dto);
        return result ? Result.success(true) : Result.errorMsg("更新采集点失败");
    }

    /**
     * 根据UUID逻辑删除采集点
     */
    @DeleteMapping("/delete/{uuid}")
    public Result<Boolean> deletePoint(
            @PathVariable String uuid,
            @RequestParam Long updateBy) {
        boolean result = dataPointService.deleteByUuid(uuid, updateBy);
        return result ? Result.success(true) : Result.errorMsg("删除采集点失败");
    }

    /**
     * 根据作业线UUID批量逻辑删除采集点
     */
    @DeleteMapping("/batch/delete/line/{dataLineUuid}")
    public Result<Boolean> batchDeleteByLine(
            @PathVariable String dataLineUuid,
            @RequestParam Long updateBy) {
        boolean result = dataPointService.batchDeleteByLineUuid(dataLineUuid, updateBy);
        return result ? Result.success(true) : Result.errorMsg("批量删除采集点失败");
    }
}