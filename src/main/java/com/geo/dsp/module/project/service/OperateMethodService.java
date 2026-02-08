package com.geo.dsp.module.project.service;

import com.geo.dsp.module.project.dto.OperateMethodDTO;
import com.geo.dsp.module.project.entity.OperateMethod;
import com.geo.dsp.module.project.vo.OperateMethodVO;
import java.util.List;

public interface OperateMethodService {

    /**
     * 根据UUID查询作业方法
     */
    OperateMethodVO getByUuid(String uuid);

    /**
     * 查询所有未删除的作业方法
     */
    List<OperateMethodVO> listAll();

    /**
     * 根据方法名称查询作业方法
     */
    OperateMethodVO getByName(String methodName);

    /**
     * 新增作业方法
     */
    boolean saveMethod(OperateMethodDTO dto);

    /**
     * 根据UUID更新作业方法
     */
    boolean updateMethod(String uuid, OperateMethodDTO dto);

    /**
     * 根据UUID逻辑删除作业方法
     */
    boolean deleteByUuid(String uuid, Long updateBy);
}