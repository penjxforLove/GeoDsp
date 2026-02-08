package com.geo.dsp.module.project.mapper;

import com.geo.dsp.module.project.entity.OperateMethod;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作业方法表Mapper接口
 * 表说明：物探作业方法定义（全局共享字典表）
 */
@Mapper
public interface OperateMethodMapper {
    /**
     * 根据UUID查询作业方法
     * @param uuid 作业方法UUID
     * @return 作业方法实体
     */
    OperateMethod selectByUuid(@Param("uuid") String uuid);

    /**
     * 查询所有作业方法（全局共享）
     * @return 作业方法列表（未删除）
     */
    List<OperateMethod> listAll();

    /**
     * 根据方法名称查询作业方法
     * @param methodName 方法名称（唯一）
     * @return 作业方法实体
     */
    OperateMethod selectByName(@Param("methodName") String methodName);

    /**
     * 新增作业方法
     * @param operateMethod 作业方法实体（含UUID）
     * @return 受影响行数
     */
    int insert(OperateMethod operateMethod);

    /**
     * 根据UUID更新作业方法
     * @param operateMethod 作业方法实体（含UUID，非空字段更新）
     * @return 受影响行数
     */
    int updateByUuid(OperateMethod operateMethod);

    /**
     * 根据UUID逻辑删除作业方法
     * @param uuid 作业方法UUID
     * @param updateBy 修改人ID
     * @return 受影响行数
     */
    int deleteByUuid(@Param("uuid") String uuid, @Param("updateBy") Long updateBy);
}