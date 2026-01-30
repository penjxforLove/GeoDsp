package com.geo.dsp.module.user.service;

import com.geo.dsp.module.user.entity.User;
import com.geo.dsp.module.user.dto.UserDTO;
import com.geo.dsp.module.user.vo.UserVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author geo
 * @since 2026-01-18
 */
public interface UserService extends IService<User> {

    /**
     * 获取用户列表（分页）
     *
     * @param page 分页参数
     * @param username 用户名（模糊查询）
     * @return 用户分页列表
     */
    IPage<UserVO> getUserPage(Page<User> page, String username);

    /**
     * 获取用户详情
     *
     * @param id 用户ID
     * @return 用户详情
     */
    UserVO getUserDetail(Long id);

    /**
     * 创建用户
     *
     * @param userDTO 用户信息
     * @return 创建结果
     */
    boolean createUser(UserDTO userDTO);

    /**
     * 更新用户
     *
     * @param userDTO 用户信息
     * @return 更新结果
     */
    boolean updateUser(UserDTO userDTO);

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return 删除结果
     */
    boolean deleteUser(Long id);

    /**
     * 批量删除用户
     *
     * @param ids 用户ID列表
     * @return 删除结果
     */
    boolean batchDeleteUser(List<Long> ids);
}