package com.geo.dsp.module.data.mapper;

import com.geo.dsp.module.data.entity.DataPoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作业点表Mapper接口
 * 表说明：作业线上的采集点/测点
 */
@Mapper
public interface DataPointMapper {
    /**
     * 根据UUID查询作业点
     * @param uuid 作业点UUID
     * @return 作业点实体
     */
    DataPoint selectByUuid(@Param("uuid") String uuid);

    /**
     * 根据作业线UUID查询作业点列表
     * @param dataLineUuid 作业线UUID
     * @return 作业点列表（未删除）
     */
    List<DataPoint> listByDataLineUuid(@Param("dataLineUuid") String dataLineUuid);

    /**
     * 新增作业点
     * @param dataPoint 作业点实体（含UUID）
     * @return 受影响行数
     */
    int insert(DataPoint dataPoint);

    /**
     * 根据UUID更新作业点
     * @param dataPoint 作业点实体（含UUID，非空字段更新）
     * @return 受影响行数
     */
    int updateByUuid(DataPoint dataPoint);

    /**
     * 根据作业线UUID批量删除作业点（逻辑删除）
     * @param dataLineUuid 作业线UUID
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int batchDeleteByDataLineUuid(@Param("dataLineUuid") String dataLineUuid, @Param("updateBy") Long updateBy);

    /**
     * 根据UUID逻辑删除作业点
     * @param uuid 作业点UUID
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int deleteByUuid(@Param("uuid") String uuid, @Param("updateBy") Long updateBy);
}