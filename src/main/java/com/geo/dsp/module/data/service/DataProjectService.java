package com.geo.dsp.module.data.service;

import com.geo.dsp.module.data.dto.DataProjectDTO;
import com.geo.dsp.module.data.vo.DataProjectVO;
import java.util.List;

public interface DataProjectService {

    /**
     * 根据UUID查询工程详情
     */
    DataProjectVO getByUuid(String uuid);

    /**
     * 根据项目UUID查询工程列表
     */
    List<DataProjectVO> listByProjectUuid(String projectUuid);

    /**
     * 根据状态查询工程列表
     */
    List<DataProjectVO> listByStatus(Integer status);

    /**
     * 新增工程
     */
    boolean saveDataProject(DataProjectDTO dto);

    /**
     * 根据UUID更新工程信息
     */
    boolean updateDataProject(String uuid, DataProjectDTO dto);

    /**
     * 根据UUID更新工程状态
     */
    boolean updateProjectStatus(String uuid, Integer status, Long updateBy);

    /**
     * 根据UUID逻辑删除工程
     */
    boolean deleteByUuid(String uuid, Long updateBy);
}