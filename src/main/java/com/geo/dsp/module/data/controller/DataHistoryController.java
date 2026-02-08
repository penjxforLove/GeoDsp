package com.geo.dsp.module.data.controller;

import com.geo.dsp.common.result.Result;
import com.geo.dsp.module.data.dto.DataHistoryDTO;
import com.geo.dsp.module.data.service.DataHistoryService;
import com.geo.dsp.module.data.vo.DataHistoryVO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/data/history")
@Validated
public class DataHistoryController {

    @Resource
    private DataHistoryService dataHistoryService;

    /**
     * 根据UUID查询历史记录详情
     */
    @GetMapping("/detail/{uuid}")
    public Result<DataHistoryVO> getHistoryByUuid(@PathVariable String uuid) {
        DataHistoryVO vo = dataHistoryService.getByUuid(uuid);
        return Result.success(vo);
    }

    /**
     * 根据采样数据UUID查询历史记录列表
     */
    @GetMapping("/list/data/{dataUuid}")
    public Result<List<DataHistoryVO>> listByDataUuid(@PathVariable String dataUuid) {
        List<DataHistoryVO> list = dataHistoryService.listByDataUuid(dataUuid);
        return Result.success(list);
    }

    /**
     * 新增采样数据历史记录
     */
    @PostMapping("/save")
    public Result<Boolean> saveHistory(@Validated @RequestBody DataHistoryDTO dto) {
        boolean result = dataHistoryService.saveHistory(dto);
        return result ? Result.success(true) : Result.errorMsg("新增历史记录失败");
    }

    /**
     * 根据UUID逻辑删除历史记录
     */
    @DeleteMapping("/delete/{uuid}")
    public Result<Boolean> deleteHistory(
            @PathVariable String uuid,
            @RequestParam Long updateBy) {
        boolean result = dataHistoryService.deleteByUuid(uuid, updateBy);
        return result ? Result.success(true) : Result.errorMsg("删除历史记录失败");
    }
}