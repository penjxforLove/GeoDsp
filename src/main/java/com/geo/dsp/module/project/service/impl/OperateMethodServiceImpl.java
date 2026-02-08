package com.geo.dsp.module.project.service.impl;

import com.geo.dsp.module.project.dto.OperateMethodDTO;
import com.geo.dsp.module.project.entity.OperateMethod;
import com.geo.dsp.module.project.mapper.OperateMethodMapper;
import com.geo.dsp.module.project.service.OperateMethodService;
import com.geo.dsp.module.project.vo.OperateMethodVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OperateMethodServiceImpl implements OperateMethodService {

    @Resource
    private OperateMethodMapper operateMethodMapper;

    /**
     * 实体转VO工具方法
     */
    private OperateMethodVO convertToVO(OperateMethod entity) {
        if (entity == null) {
            return null;
        }
        OperateMethodVO vo = new OperateMethodVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    @Override
    public OperateMethodVO getByUuid(String uuid) {
        if (!StringUtils.hasText(uuid)) {
            return null;
        }
        OperateMethod method = operateMethodMapper.selectByUuid(uuid);
        return convertToVO(method);
    }

    @Override
    public List<OperateMethodVO> listAll() {
        List<OperateMethod> list = operateMethodMapper.listAll();
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public OperateMethodVO getByName(String methodName) {
        if (!StringUtils.hasText(methodName)) {
            return null;
        }
        OperateMethod method = operateMethodMapper.selectByName(methodName);
        return convertToVO(method);
    }

    @Override
    public boolean saveMethod(OperateMethodDTO dto) {
        try {
            OperateMethod entity = new OperateMethod();
            // 属性拷贝
            BeanUtils.copyProperties(dto, entity);
            // 填充系统字段
            entity.setUuid(UUID.randomUUID().toString());
            entity.setCreateBy(dto.getOperatorId());
            entity.setUpdateBy(dto.getOperatorId());
            entity.setCreateTime(LocalDateTime.now());
            entity.setUpdateTime(LocalDateTime.now());
            entity.setIsDel(false);
            // 执行插入
            int rows = operateMethodMapper.insert(entity);
            log.info("新增作业方法成功，UUID:{}", entity.getUuid());
            return rows > 0;
        } catch (Exception e) {
            log.error("新增作业方法失败", e);
            return false;
        }
    }

    @Override
    public boolean updateMethod(String uuid, OperateMethodDTO dto) {
        // 参数校验
        if (!StringUtils.hasText(uuid) || dto == null) {
            log.warn("更新作业方法参数不合法，uuid:{}", uuid);
            return false;
        }
        try {
            OperateMethod entity = new OperateMethod();
            BeanUtils.copyProperties(dto, entity);
            // 设置更新条件和系统字段
            entity.setUuid(uuid);
            entity.setUpdateBy(dto.getOperatorId());
            entity.setUpdateTime(LocalDateTime.now());
            // 执行更新
            int rows = operateMethodMapper.updateByUuid(entity);
            log.info("更新作业方法成功，UUID:{}，影响行数:{}", uuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("更新作业方法失败，UUID:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean deleteByUuid(String uuid, Long updateBy) {
        // 参数校验
        if (!StringUtils.hasText(uuid) || updateBy == null) {
            log.warn("删除作业方法参数不合法，uuid:{}，updateBy:{}", uuid, updateBy);
            return false;
        }
        try {
            int rows = operateMethodMapper.deleteByUuid(uuid, updateBy);
            log.info("逻辑删除作业方法成功，UUID:{}，影响行数:{}", uuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("逻辑删除作业方法失败，UUID:{}", uuid, e);
            return false;
        }
    }
}