package com.geo.dsp.module.data.service;

import com.geo.dsp.module.data.dto.DataPointDTO;
import com.geo.dsp.module.data.vo.DataPointVO;
import java.util.List;

public interface DataPointService {

    /**
     * 根据UUID查询采集点详情
     */
    DataPointVO getByUuid(String uuid);

    /**
     * 根据作业线UUID查询采集点列表
     */
    List<DataPointVO> listByDataLineUuid(String dataLineUuid);

    /**
     * 新增采集点
     */
    boolean saveDataPoint(DataPointDTO dto);

    /**
     * 根据UUID更新采集点信息
     */
    boolean updateDataPoint(String uuid, DataPointDTO dto);

    /**
     * 根据UUID逻辑删除采集点
     */
    boolean deleteByUuid(String uuid, Long updateBy);

    /**
     * 根据作业线UUID批量逻辑删除采集点
     */
    boolean batchDeleteByLineUuid(String dataLineUuid, Long updateBy);
}