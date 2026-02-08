package com.geo.dsp.module.data.service.impl;

import com.geo.dsp.module.data.dto.DataProjectDTO;
import com.geo.dsp.module.data.entity.DataProject;
import com.geo.dsp.module.data.mapper.DataProjectMapper;
import com.geo.dsp.module.data.service.DataProjectService;
import com.geo.dsp.module.data.vo.DataProjectVO;
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
public class DataProjectServiceImpl implements DataProjectService {

    @Resource
    private DataProjectMapper dataProjectMapper;

    /**
     * 实体转换为VO工具方法
     */
    private DataProjectVO convertToVO(DataProject entity) {
        if (entity == null) {
            return null;
        }
        DataProjectVO vo = new DataProjectVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    @Override
    public DataProjectVO getByUuid(String uuid) {
        if (!StringUtils.hasText(uuid)) {
            return null;
        }
        DataProject dataProject = dataProjectMapper.selectByUuid(uuid);
        return convertToVO(dataProject);
    }

    @Override
    public List<DataProjectVO> listByProjectUuid(String projectUuid) {
        if (!StringUtils.hasText(projectUuid)) {
            return Collections.emptyList();
        }
        List<DataProject> list = dataProjectMapper.listByProjectUuid(projectUuid);
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public List<DataProjectVO> listByStatus(Integer status) {
        if (status == null) {
            return Collections.emptyList();
        }
        List<DataProject> list = dataProjectMapper.listByStatus(status);
        return list.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public boolean saveDataProject(DataProjectDTO dto) {
        try {
            DataProject entity = new DataProject();
            // 属性拷贝
            BeanUtils.copyProperties(dto, entity);
            // 填充系统自动生成字段
            entity.setUuid(UUID.randomUUID().toString());
            entity.setCreateBy(dto.getOperatorId());
            entity.setUpdateBy(dto.getOperatorId());
            entity.setCreateTime(LocalDateTime.now());
            entity.setUpdateTime(LocalDateTime.now());
            // 初始化状态：未开始
            entity.setStatus(dto.getStatus() == null ? 0 : dto.getStatus());
            entity.setIsDel(false);

            int rows = dataProjectMapper.insert(entity);
            log.info("新增工程成功，UUID:{}", entity.getUuid());
            return rows > 0;
        } catch (Exception e) {
            log.error("新增工程失败", e);
            return false;
        }
    }

    @Override
    public boolean updateDataProject(String uuid, DataProjectDTO dto) {
        if (!StringUtils.hasText(uuid) || dto == null) {
            log.warn("更新工程参数不合法，uuid:{}", uuid);
            return false;
        }
        try {
            DataProject entity = new DataProject();
            BeanUtils.copyProperties(dto, entity);
            // 设置更新条件和系统字段
            entity.setUuid(uuid);
            entity.setUpdateBy(dto.getOperatorId());
            entity.setUpdateTime(LocalDateTime.now());

            int rows = dataProjectMapper.updateByUuid(entity);
            log.info("更新工程信息成功，UUID:{}，影响行数:{}", uuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("更新工程信息失败，UUID:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean updateProjectStatus(String uuid, Integer status, Long updateBy) {
        if (!StringUtils.hasText(uuid) || status == null || updateBy == null) {
            log.warn("更新工程状态参数不合法，uuid:{}, status:{}, updateBy:{}", uuid, status, updateBy);
            return false;
        }
        try {
            int rows = dataProjectMapper.updateStatusByUuid(uuid, status, updateBy);
            log.info("更新工程状态成功，UUID:{}，新状态:{}", uuid, status);
            return rows > 0;
        } catch (Exception e) {
            log.error("更新工程状态失败，UUID:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean deleteByUuid(String uuid, Long updateBy) {
        if (!StringUtils.hasText(uuid) || updateBy == null) {
            log.warn("删除工程参数不合法，uuid:{}, updateBy:{}", uuid, updateBy);
            return false;
        }
        try {
            int rows = dataProjectMapper.deleteByUuid(uuid, updateBy);
            log.info("逻辑删除工程成功，UUID:{}", uuid);
            return rows > 0;
        } catch (Exception e) {
            log.error("逻辑删除工程失败，UUID:{}", uuid, e);
            return false;
        }
    }
}