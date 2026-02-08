package com.geo.dsp.module.project.service;

import com.geo.dsp.module.project.dto.ProjectDTO;
import com.geo.dsp.module.project.entity.Project;
import com.geo.dsp.module.project.vo.ProjectVO;
import java.util.List;

public interface ProjectService {

    /**
     * 根据UUID查询项目详情
     */
    ProjectVO getProjectByUuid(String uuid);

    /**
     * 根据企业UUID查询项目列表
     */
    List<ProjectVO> listByCompanyUuid(String companyUuid);

    /**
     * 根据状态查询项目列表
     */
    List<ProjectVO> listByStatus(Integer status);

    /**
     * 新增项目
     */
    boolean saveProject(ProjectDTO dto);

    /**
     * 根据UUID更新项目信息
     */
    boolean updateProject(String uuid, ProjectDTO dto);

    /**
     * 根据UUID更新项目状态
     */
    boolean updateProjectStatus(String uuid, Integer status, Long updateBy);

    /**
     * 根据UUID逻辑删除项目
     */
    boolean deleteProject(String uuid, Long updateBy);
}