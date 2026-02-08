package com.geo.dsp.module.data.controller;

import com.geo.dsp.common.result.Result;
import com.geo.dsp.module.data.dto.CollectPhotoDTO;
import com.geo.dsp.module.data.service.CollectPhotoService;
import com.geo.dsp.module.data.vo.CollectPhotoVO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/data/collect/photo")
@Validated
public class CollectPhotoController {

    @Resource
    private CollectPhotoService collectPhotoService;

    /**
     * 根据主键ID查询照片信息
     */
    @GetMapping("/detail/id/{id}")
    public Result<CollectPhotoVO> getPhotoById(@PathVariable Long id) {
        CollectPhotoVO vo = collectPhotoService.getById(id);
        return Result.success(vo);
    }

    /**
     * 根据UUID查询照片信息
     */
    @GetMapping("/detail/uuid/{uuid}")
    public Result<CollectPhotoVO> getPhotoByUuid(@PathVariable String uuid) {
        CollectPhotoVO vo = collectPhotoService.getByUuid(uuid);
        return Result.success(vo);
    }

    /**
     * 根据测点ID查询照片列表
     */
    @GetMapping("/list/point/id/{pointId}")
    public Result<List<CollectPhotoVO>> listByPointId(@PathVariable Long pointId) {
        List<CollectPhotoVO> list = collectPhotoService.listByPointId(pointId);
        return Result.success(list);
    }

    /**
     * 根据测点UUID查询照片列表
     */
    @GetMapping("/list/point/uuid/{pointUuid}")
    public Result<List<CollectPhotoVO>> listByPointUuid(@PathVariable String pointUuid) {
        List<CollectPhotoVO> list = collectPhotoService.listByPointUuid(pointUuid);
        return Result.success(list);
    }

    /**
     * 上传并保存采集照片
     */
    @PostMapping("/save")
    public Result<Boolean> savePhoto(@Validated @RequestBody CollectPhotoDTO dto) {
        boolean result = collectPhotoService.savePhoto(dto);
        return result ? Result.success(true) : Result.errorMsg("上传照片失败");
    }

    /**
     * 修改照片备注
     */
    @PutMapping("/update/note")
    public Result<Boolean> updatePhotoNote(
            @RequestParam Long id,
            @RequestParam(required = false) String note) {
        boolean result = collectPhotoService.updateNote(id, note);
        return result ? Result.success(true) : Result.errorMsg("修改备注失败");
    }

    /**
     * 根据ID逻辑删除照片
     */
    @DeleteMapping("/delete/id/{id}")
    public Result<Boolean> deletePhotoById(@PathVariable Long id) {
        boolean result = collectPhotoService.deleteById(id);
        return result ? Result.success(true) : Result.errorMsg("删除照片失败");
    }

    /**
     * 根据UUID逻辑删除照片
     */
    @DeleteMapping("/delete/uuid/{uuid}")
    public Result<Boolean> deletePhotoByUuid(@PathVariable String uuid) {
        boolean result = collectPhotoService.deleteByUuid(uuid);
        return result ? Result.success(true) : Result.errorMsg("删除照片失败");
    }

    /**
     * 根据测点ID批量逻辑删除照片
     */
    @DeleteMapping("/batch/delete/point/{pointId}")
    public Result<Boolean> batchDeleteByPointId(@PathVariable Long pointId) {
        boolean result = collectPhotoService.batchDeleteByPointId(pointId);
        return result ? Result.success(true) : Result.errorMsg("批量删除照片失败");
    }
}