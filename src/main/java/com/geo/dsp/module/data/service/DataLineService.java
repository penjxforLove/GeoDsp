package com.geo.dsp.module.data.service;

import com.geo.dsp.module.data.dto.DataLineDTO;
import com.geo.dsp.module.data.vo.DataLineVO;
import java.util.List;

public interface DataLineService {

    /**
     * 根据UUID查询作业线详情
     */
    DataLineVO getByUuid(String uuid);

    /**
     * 根据工程UUID查询作业线列表
     */
    List<DataLineVO> listByEngineeringUuid(String engineeringUuid);

    /**
     * 根据状态查询作业线列表
     */
    List<DataLineVO> listByStatus(Integer status);

    /**
     * 新增作业线
     */
    boolean saveDataLine(DataLineDTO dto);

    /**
     * 根据UUID更新作业线信息
     */
    boolean updateDataLine(String uuid, DataLineDTO dto);

    /**
     * 根据UUID更新作业线状态
     */
    boolean updateLineStatus(String uuid, Integer status, Long updateBy);

    /**
     * 根据UUID逻辑删除作业线
     */
    boolean deleteByUuid(String uuid, Long updateBy);

    /**
     * 根据工程UUID批量逻辑删除作业线
     */
    boolean batchDeleteByEngineeringUuid(String engineeringUuid, Long updateBy);
}