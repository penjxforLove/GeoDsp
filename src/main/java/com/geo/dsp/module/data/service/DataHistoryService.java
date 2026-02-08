package com.geo.dsp.module.data.service;

import com.geo.dsp.module.data.dto.DataHistoryDTO;
import com.geo.dsp.module.data.vo.DataHistoryVO;
import java.util.List;

public interface DataHistoryService {

    /**
     * 根据UUID查询单条历史记录
     */
    DataHistoryVO getByUuid(String uuid);

    /**
     * 根据采样数据UUID查询历史记录列表
     */
    List<DataHistoryVO> listByDataUuid(String dataUuid);

    /**
     * 新增采样数据历史记录
     */
    boolean saveHistory(DataHistoryDTO dto);

    /**
     * 根据UUID逻辑删除历史记录
     */
    boolean deleteByUuid(String uuid, Long updateBy);
}