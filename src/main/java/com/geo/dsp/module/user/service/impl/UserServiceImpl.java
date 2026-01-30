package com.geo.dsp.module.user.service.impl;

import com.geo.dsp.module.user.dto.UserDTO;
import com.geo.dsp.module.user.entity.User;
import com.geo.dsp.module.user.mapper.UserMapper;
import com.geo.dsp.module.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geo.dsp.module.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author geo
 * @since 2026-01-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<UserVO> getUserPage(Page<User> page, String username) {
        // 使用自定义SQL查询
        List<User> userList = userMapper.getUserPage(page, username);
        return page.setRecords(userList).convert(user -> {
            UserVO vo = new UserVO();
            // 实体转VO
            vo.setId(user.getId());
            vo.setUsername(user.getUsername());
            vo.setRealName(user.getRealName());
            vo.setEmail(user.getEmail());
            vo.setPhone(user.getPhone());
            vo.setStatus(user.getStatus());
            vo.setCreateTime(user.getCreateTime());
            return vo;
        });
    }

    @Override
    public UserVO getUserDetail(Long id) {
        User user = userMapper.getUserDetail(id);
        if (user == null) {
            return null;
        }
        UserVO vo = new UserVO();
        // 实体转VO
        vo.setId(user.getId());
        vo.setUsername(user.getUsername());
        vo.setRealName(user.getRealName());
        vo.setEmail(user.getEmail());
        vo.setPhone(user.getPhone());
        vo.setStatus(user.getStatus());
        vo.setCreateTime(user.getCreateTime());
        vo.setUpdateTime(user.getUpdateTime());
        return vo;
    }

    @Override
    public boolean createUser(UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean deleteUser(Long id) {
        return false;
    }

    @Override
    public boolean batchDeleteUser(List<Long> ids) {
        return false;
    }
}