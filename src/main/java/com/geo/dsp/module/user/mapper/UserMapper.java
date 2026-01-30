package com.geo.dsp.module.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geo.dsp.module.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author geo
 * @since 2026-01-18
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 获取用户详情
     * @param id 用户ID
     * @return 用户信息
     */
    User getUserDetail(@Param("id") Long id);

    /**
     * 用户分页查询
     * @param page 分页参数
     * @param username 用户名（模糊查询）
     * @return 用户列表
     */
    List<User> getUserPage(@Param("page") Page<User> page, @Param("username") String username);

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户信息
     */
    User selectByUsername(@Param("username") String username);

    /**
     * 批量删除用户
     * @param ids 用户ID列表
     * @return 删除数量
     */
    int batchDelete(@Param("ids") List<Long> ids);
}