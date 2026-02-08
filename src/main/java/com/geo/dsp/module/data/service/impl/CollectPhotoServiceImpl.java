package com.geo.dsp.module.data.service.impl;

import com.geo.dsp.module.data.dto.CollectPhotoDTO;
import com.geo.dsp.module.data.entity.CollectPhoto;
import com.geo.dsp.module.data.mapper.CollectPhotoMapper;
import com.geo.dsp.module.data.service.CollectPhotoService;
import com.geo.dsp.module.data.vo.CollectPhotoVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CollectPhotoServiceImpl implements CollectPhotoService {

    @Resource
    private CollectPhotoMapper collectPhotoMapper;

    /**
     * 实体转换为VO工具方法
     */
    private CollectPhotoVO convertToVO(CollectPhoto entity) {
        if (entity == null) {
            return null;
        }
        CollectPhotoVO vo = new CollectPhotoVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    @Override
    public CollectPhotoVO getById(Long id) {
        if (id == null || id <= 0) {
            return null;
        }
        CollectPhoto photo = collectPhotoMapper.selectById(id);
        return convertToVO(photo);
    }

    @Override
    public CollectPhotoVO getByUuid(String uuid) {
        if (!StringUtils.hasText(uuid)) {
            return null;
        }
        CollectPhoto photo = collectPhotoMapper.selectByUuid(uuid);
        return convertToVO(photo);
    }

    @Override
    public List<CollectPhotoVO> listByPointId(Long pointId) {
        if (pointId == null || pointId <= 0) {
            return Collections.emptyList();
        }
        List<CollectPhoto> list = collectPhotoMapper.listByPointId(pointId);
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public List<CollectPhotoVO> listByPointUuid(String pointUuid) {
        if (!StringUtils.hasText(pointUuid)) {
            return Collections.emptyList();
        }
        List<CollectPhoto> list = collectPhotoMapper.listByPointUuid(pointUuid);
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public boolean savePhoto(CollectPhotoDTO dto) {
        try {
            CollectPhoto entity = new CollectPhoto();
            // 属性拷贝
            BeanUtils.copyProperties(dto, entity);
            // 填充系统自动生成字段
            entity.setUuid(UUID.randomUUID().toString());
            entity.setUploadTime(LocalDateTime.now());
            entity.setIsDel(false);

            int rows = collectPhotoMapper.insert(entity);
            log.info("新增采集照片成功，UUID:{}", entity.getUuid());
            return rows > 0;
        } catch (Exception e) {
            log.error("新增采集照片失败", e);
            return false;
        }
    }

    @Override
    public boolean updateNote(Long id, String note) {
        if (id == null || id <= 0) {
            log.warn("修改照片备注参数不合法，id:{}", id);
            return false;
        }
        try {
            int rows = collectPhotoMapper.updateNote(id, note);
            log.info("修改照片备注成功，id:{}，影响行数:{}", id, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("修改照片备注失败，id:{}", id, e);
            return false;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if (id == null || id <= 0) {
            log.warn("删除照片参数不合法，id:{}", id);
            return false;
        }
        try {
            int rows = collectPhotoMapper.deleteById(id);
            log.info("逻辑删除照片成功，id:{}，影响行数:{}", id, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("逻辑删除照片失败，id:{}", id, e);
            return false;
        }
    }

    @Override
    public boolean deleteByUuid(String uuid) {
        if (!StringUtils.hasText(uuid)) {
            log.warn("删除照片参数不合法，uuid:{}", uuid);
            return false;
        }
        try {
            int rows = collectPhotoMapper.deleteByUuid(uuid);
            log.info("逻辑删除照片成功，uuid:{}，影响行数:{}", uuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("逻辑删除照片失败，uuid:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean batchDeleteByPointId(Long pointId) {
        if (pointId == null || pointId <= 0) {
            log.warn("批量删除照片参数不合法，pointId:{}", pointId);
            return false;
        }
        try {
            int rows = collectPhotoMapper.batchDeleteByPointId(pointId);
            log.info("批量逻辑删除照片成功，pointId:{}，影响行数:{}", pointId, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("批量逻辑删除照片失败，pointId:{}", pointId, e);
            return false;
        }
    }
}