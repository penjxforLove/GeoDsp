package com.geo.dsp.module.data.service;

import com.geo.dsp.module.data.dto.CollectPhotoDTO;
import com.geo.dsp.module.data.entity.CollectPhoto;
import com.geo.dsp.module.data.vo.CollectPhotoVO;
import java.util.List;

public interface CollectPhotoService {

    /**
     * 根据主键ID查询照片
     */
    CollectPhotoVO getById(Long id);

    /**
     * 根据UUID查询照片
     */
    CollectPhotoVO getByUuid(String uuid);

    /**
     * 根据测点ID查询照片列表
     */
    List<CollectPhotoVO> listByPointId(Long pointId);

    /**
     * 根据测点UUID查询照片列表
     */
    List<CollectPhotoVO> listByPointUuid(String pointUuid);

    /**
     * 新增采集照片
     */
    boolean savePhoto(CollectPhotoDTO dto);

    /**
     * 根据ID修改照片备注
     */
    boolean updateNote(Long id, String note);

    /**
     * 根据ID逻辑删除照片
     */
    boolean deleteById(Long id);

    /**
     * 根据UUID逻辑删除照片
     */
    boolean deleteByUuid(String uuid);

    /**
     * 根据测点ID批量逻辑删除照片
     */
    boolean batchDeleteByPointId(Long pointId);
}