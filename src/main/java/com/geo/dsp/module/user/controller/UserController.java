package com.geo.dsp.module.user.controller;

import com.geo.dsp.common.result.Result;
import com.geo.dsp.module.user.vo.UserVO;
import com.geo.dsp.module.user.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.geo.dsp.module.user.dto.UserDTO;
import com.geo.dsp.module.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author geo
 * @since 2024-01-18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表（分页）
     *
     * @param page 当前页码
     * @param size 每页条数
     * @param username 用户名（模糊查询）
     * @return 用户分页列表
     */
    @GetMapping("/page")
    public Result<IPage<UserVO>> getUserPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String username) {
        logger.info("获取用户列表，页码：{}，每页条数：{}，用户名：{}", page, size, username);

        Page<User> userPage = new Page<>(page, size);
        IPage<UserVO> result = userService.getUserPage(userPage, username);

        logger.debug("获取用户列表成功，总条数：{}", result.getTotal());
        return Result.success(result);
    }

    /**
     * 获取用户详情
     *
     * @param id 用户ID
     * @return 用户详情
     */
    @GetMapping("/{id}")
    public Result<UserVO> getUserDetail(@PathVariable Long id) {
        logger.info("获取用户详情，ID：{}", id);

        UserVO userVO = userService.getUserDetail(id);

        logger.debug("获取用户详情成功，用户名：{}", userVO.getUsername());
        return Result.success(userVO);
    }

    /**
     * 创建用户
     *
     * @param userDTO 用户信息
     * @return 创建结果
     */
    @PostMapping("/create")
    public Result<Boolean> createUser(@Validated @RequestBody UserDTO userDTO) {
        logger.info("创建用户，用户名：{}", userDTO.getUsername());

        boolean result = userService.createUser(userDTO);

        logger.info("创建用户成功，用户名：{}", userDTO.getUsername());
        return Result.success(result);
    }

    /**
     * 更新用户
     *
     * @param userDTO 用户信息
     * @return 更新结果
     */
    @PutMapping("/update")
    public Result<Boolean> updateUser(@Validated @RequestBody UserDTO userDTO) {
        logger.info("更新用户，ID：{}", userDTO.getId());

        boolean result = userService.updateUser(userDTO);

        logger.info("更新用户成功，ID：{}", userDTO.getId());
        return Result.success(result);
    }

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteUser(@PathVariable Long id) {
        logger.info("删除用户，ID：{}", id);

        boolean result = userService.deleteUser(id);

        logger.info("删除用户成功，ID：{}", id);
        return Result.success(result);
    }

    /**
     * 批量删除用户
     *
     * @param ids 用户ID列表
     * @return 删除结果
     */
    @DeleteMapping("/batch")
    public Result<Boolean> batchDeleteUser(@RequestBody List<Long> ids) {
        logger.info("批量删除用户，ID列表：{}", ids);

        boolean result = userService.batchDeleteUser(ids);

        logger.info("批量删除用户成功，共删除：{}个用户", ids.size());
        return Result.success(result);
    }
}
