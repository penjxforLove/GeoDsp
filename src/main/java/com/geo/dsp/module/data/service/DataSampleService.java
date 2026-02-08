package com.geo.dsp.module.data.service;

import com.geo.dsp.module.data.dto.DataSampleDTO;
import com.geo.dsp.module.data.vo.DataSampleVO;
import java.util.List;

public interface DataSampleService {

    /**
     * 根据UUID查询采样数据基础信息
     */
    DataSampleVO getByUuid(String uuid);

    /**
     * 根据作业点UUID查询采样数据列表
     */
    List<DataSampleVO> listByDataPointUuid(String dataPointUuid);

    /**
     * 根据采集任务UUID查询采样数据列表
     */
    List<DataSampleVO> listByTaskUuid(String taskUuid);

    /**
     * 新增采样数据
     */
    boolean saveSample(DataSampleDTO dto);

    /**
     * 根据UUID更新采样数据
     */
    boolean updateSample(String uuid, DataSampleDTO dto);

    /**
     * 根据UUID逻辑删除采样数据
     */
    boolean deleteByUuid(String uuid, Long updateBy);

    /**
     * 根据作业点UUID批量逻辑删除采样数据
     */
    boolean batchDeleteByPointUuid(String dataPointUuid, Long updateBy);
}