package com.geo.dsp.module.data.mapper;

import com.geo.dsp.module.data.entity.DataLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作业线表Mapper接口
 * 表说明：工程下的作业线路/测线
 */
@Mapper
public interface DataLineMapper {
    /**
     * 根据UUID查询作业线
     * @param uuid 作业线UUID
     * @return 作业线实体
     */
    DataLine selectByUuid(@Param("uuid") String uuid);

    /**
     * 根据工程UUID查询作业线列表
     * @param engineeringUuid 工程UUID
     * @return 作业线列表（未删除）
     */
    List<DataLine> listByEngineeringUuid(@Param("engineeringUuid") String engineeringUuid);

    /**
     * 根据状态查询作业线列表
     * @param status 作业线状态（0-未开始，1-进行中，2-已完成，3-审核中，4-已审核）
     * @return 作业线列表（未删除）
     */
    List<DataLine> listByStatus(@Param("status") Integer status);

    /**
     * 新增作业线
     * @param dataLine 作业线实体（含UUID）
     * @return 受影响行数
     */
    int insert(DataLine dataLine);

    /**
     * 根据UUID更新作业线
     * @param dataLine 作业线实体（含UUID，非空字段更新）
     * @return 受影响行数
     */
    int updateByUuid(DataLine dataLine);

    /**
     * 根据UUID修改作业线状态
     * @param uuid 作业线UUID
     * @param status 目标状态
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int updateStatusByUuid(@Param("uuid") String uuid, @Param("status") Integer status, @Param("updateBy") Long updateBy);

    /**
     * 根据工程UUID批量删除作业线（逻辑删除）
     * @param engineeringUuid 工程UUID
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int batchDeleteByEngineeringUuid(@Param("engineeringUuid") String engineeringUuid, @Param("updateBy") Long updateBy);

    /**
     * 根据UUID逻辑删除作业线
     * @param uuid 作业线UUID
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int deleteByUuid(@Param("uuid") String uuid, @Param("updateBy") Long updateBy);
}