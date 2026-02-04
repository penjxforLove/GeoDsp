package com.geo.dsp.module.data.mapper;

import com.geo.dsp.module.data.entity.CollectPhoto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 采集照片表Mapper接口
 * 对应表：collect_photo
 * 功能：采集照片的增删改查、UUID专属操作
 */
@Mapper
public interface CollectPhotoMapper {

    /**
     * 根据ID查询采集照片
     *
     * @param id  照片主键ID
     * @return CollectPhoto  照片信息实体
     */
    CollectPhoto selectById(@Param("id") Long id);

    /**
     * 根据测点ID查询采集照片列表
     *
     * @param pointId 测点数据主键ID
     * @return List<CollectPhoto> 符合条件的照片列表
     */
    List<CollectPhoto> listByPointId(@Param("pointId") Long pointId);

    /**
     * 新增采集照片
     *
     * @param collectPhoto 照片信息实体
     * @return int  受影响行数
     */
    int insert(CollectPhoto collectPhoto);

    /**
     * 修改照片备注信息
     *
     * @param id   照片主键ID
     * @param note 备注内容
     * @return int  受影响行数
     */
    int updateNote(@Param("id") Long id, @Param("note") String note);

    /**
     * 根据ID删除采集照片（逻辑删除）
     *
     * @param id 照片主键ID
     * @return int  受影响行数
     */
    int deleteById(@Param("id") Long id);

    /**
     * 根据测点ID批量删除采集照片（逻辑删除）
     *
     * @param pointId 测点数据主键ID
     * @return int  受影响行数
     */
    int batchDeleteByPointId(@Param("pointId") Long pointId);

    /**
     * 根据UUID查询采集照片
     *
     * @param uuid 照片唯一标识
     * @return CollectPhoto  照片信息实体
     */
    CollectPhoto selectByUuid(@Param("uuid") String uuid);

    /**
     * 根据UUID删除采集照片（逻辑删除）
     *
     * @param uuid 照片唯一标识
     * @return int  受影响行数
     */
    int deleteByUuid(@Param("uuid") String uuid);

    /**
     * 根据测点UUID查询采集照片列表
     *
     * @param pointUuid 测点数据唯一标识
     * @return List<CollectPhoto> 符合条件的照片列表
     */
    List<CollectPhoto> listByPointUuid(@Param("pointUuid") String pointUuid);
}