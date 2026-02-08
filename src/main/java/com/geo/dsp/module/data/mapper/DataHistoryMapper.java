package com.geo.dsp.module.data.mapper;

import com.geo.dsp.module.data.entity.DataHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 历史数据表Mapper接口
 * 表说明：采样数据修改历史追溯
 */
@Mapper
public interface DataHistoryMapper {
    /**
     * 根据UUID查询历史记录
     * @param uuid 历史记录UUID
     * @return 历史记录实体
     */
    DataHistory selectByUuid(@Param("uuid") String uuid);

    /**
     * 根据采样数据UUID查询历史记录列表
     * @param dataUuid 采样数据UUID
     * @return 历史记录列表（未删除）
     */
    List<DataHistory> listByDataUuid(@Param("dataUuid") String dataUuid);

    /**
     * 新增历史记录
     * @param dataHistory 历史记录实体（含UUID）
     * @return 受影响行数
     */
    int insert(DataHistory dataHistory);

    /**
     * 根据UUID逻辑删除历史记录
     * @param uuid 历史记录UUID
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int deleteByUuid(@Param("uuid") String uuid, @Param("updateBy") Long updateBy);
}