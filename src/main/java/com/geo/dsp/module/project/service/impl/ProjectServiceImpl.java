package com.geo.dsp.module.project.service.impl;

import com.geo.dsp.module.project.dto.ProjectDTO;
import com.geo.dsp.module.project.entity.Project;
import com.geo.dsp.module.project.mapper.ProjectMapper;
import com.geo.dsp.module.project.service.ProjectService;
import com.geo.dsp.module.project.vo.ProjectVO;
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
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    /**
     * 实体转换为VO工具方法
     */
    private ProjectVO convertToVO(Project entity) {
        if (entity == null) {
            return null;
        }
        ProjectVO vo = new ProjectVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    @Override
    public ProjectVO getProjectByUuid(String uuid) {
        if (!StringUtils.hasText(uuid)) {
            return null;
        }
        Project project = projectMapper.selectByUuid(uuid);
        return convertToVO(project);
    }

    @Override
    public List<ProjectVO> listByCompanyUuid(String companyUuid) {
        if (!StringUtils.hasText(companyUuid)) {
            return Collections.emptyList();
        }
        List<Project> projectList = projectMapper.listByCompanyUuid(companyUuid);
        return projectList.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public List<ProjectVO> listByStatus(Integer status) {
        if (status == null) {
            return Collections.emptyList();
        }
        List<Project> projectList = projectMapper.listByStatus(status);
        return projectList.stream().map(this::convertToVO).collect(Collectors.toList());
    }

    @Override
    public boolean saveProject(ProjectDTO dto) {
        try {
            Project project = new Project();
            // 属性拷贝
            BeanUtils.copyProperties(dto, project);
            // 填充系统自动生成字段
            project.setUuid(UUID.randomUUID().toString());
            project.setCreateBy(dto.getOperatorId());
            project.setUpdateBy(dto.getOperatorId());
            project.setCreateTime(LocalDateTime.now());
            project.setUpdateTime(LocalDateTime.now());
            // 初始化状态：未开始
            project.setStatus(dto.getStatus() == null ? 0 : dto.getStatus());
            // 初始化删除标记
            project.setIsDel(false);

            int rows = projectMapper.insert(project);
            log.info("新增项目成功，UUID:{}", project.getUuid());
            return rows > 0;
        } catch (Exception e) {
            log.error("新增项目失败", e);
            return false;
        }
    }

    @Override
    public boolean updateProject(String uuid, ProjectDTO dto) {
        // 基础参数校验
        if (!StringUtils.hasText(uuid) || dto == null) {
            log.warn("更新项目参数不合法，uuid:{}", uuid);
            return false;
        }
        try {
            Project project = new Project();
            BeanUtils.copyProperties(dto, project);
            // 设置更新条件和系统字段
            project.setUuid(uuid);
            project.setUpdateBy(dto.getOperatorId());
            project.setUpdateTime(LocalDateTime.now());

            int rows = projectMapper.updateByUuid(project);
            log.info("更新项目信息成功，UUID:{}，影响行数:{}", uuid, rows);
            return rows > 0;
        } catch (Exception e) {
            log.error("更新项目信息失败，UUID:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean updateProjectStatus(String uuid, Integer status, Long updateBy) {
        if (!StringUtils.hasText(uuid) || status == null || updateBy == null) {
            log.warn("更新项目状态参数不合法，uuid:{}, status:{}, updateBy:{}", uuid, status, updateBy);
            return false;
        }
        try {
            int rows = projectMapper.updateStatusByUuid(uuid, status, updateBy);
            log.info("更新项目状态成功，UUID:{}，新状态:{}", uuid, status);
            return rows > 0;
        } catch (Exception e) {
            log.error("更新项目状态失败，UUID:{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean deleteProject(String uuid, Long updateBy) {
        if (!StringUtils.hasText(uuid) || updateBy == null) {
            log.warn("删除项目参数不合法，uuid:{}, updateBy:{}", uuid, updateBy);
            return false;
        }
        try {
            int rows = projectMapper.deleteByUuid(uuid, updateBy);
            log.info("逻辑删除项目成功，UUID:{}", uuid);
            return rows > 0;
        } catch (Exception e) {
            log.error("逻辑删除项目失败，UUID:{}", uuid, e);
            return false;
        }
    }
}