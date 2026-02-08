package com.geo.dsp.module.data.mapper;

import com.geo.dsp.module.data.entity.DataSample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 采样数据表Mapper接口
 * 表说明：物探采集的原始数据
 */
@Mapper
public interface DataSampleMapper {
    /**
     * 根据UUID查询采样数据
     * @param uuid 采样数据UUID
     * @return 采样数据实体
     */
    DataSample selectByUuid(@Param("uuid") String uuid);

    /**
     * 根据作业点UUID查询采样数据列表
     * @param dataPointUuid 作业点UUID
     * @return 采样数据列表（未删除）
     */
    List<DataSample> listByDataPointUuid(@Param("dataPointUuid") String dataPointUuid);

    /**
     * 根据采集任务UUID查询采样数据列表
     * @param taskUuid 采集任务UUID
     * @return 采样数据列表（未删除）
     */
    List<DataSample> listByTaskUuid(@Param("taskUuid") String taskUuid);

    /**
     * 新增采样数据
     * @param dataSample 采样数据实体（含UUID）
     * @return 受影响行数
     */
    int insert(DataSample dataSample);

    /**
     * 根据UUID更新采样数据
     * @param dataSample 采样数据实体（含UUID，非空字段更新）
     * @return 受影响行数
     */
    int updateByUuid(DataSample dataSample);

    /**
     * 根据作业点UUID批量删除采样数据（逻辑删除）
     * @param dataPointUuid 作业点UUID
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int batchDeleteByDataPointUuid(@Param("dataPointUuid") String dataPointUuid, @Param("updateBy") Long updateBy);

    /**
     * 根据UUID逻辑删除采样数据
     * @param uuid 采样数据UUID
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int deleteByUuid(@Param("uuid") String uuid, @Param("updateBy") Long updateBy);
}