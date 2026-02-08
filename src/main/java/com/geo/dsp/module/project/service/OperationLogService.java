package com.geo.dsp.module.project.service;

import com.geo.dsp.module.project.dto.OperationLogDTO;
import com.geo.dsp.module.project.entity.OperationLog;
import com.geo.dsp.module.project.vo.OperationLogVO;

import java.time.LocalDate;
import java.util.List;

public interface OperationLogService {

    /**
     * 根据UUID查询单条作业日志
     */
    OperationLogVO getByUuid(String uuid);

    /**
     * 根据项目ID查询作业日志列表
     */
    List<OperationLogVO> listByProjectId(Long projectId);

    /**
     * 根据任务ID查询作业日志列表
     */
    List<OperationLogVO> listByTaskId(Long taskId);

    /**
     * 根据日志日期+创建人查询作业日志
     */
    List<OperationLogVO> listByLogDate(LocalDate logDate, Long creatorId);

    /**
     * 新增作业日志
     */
    boolean saveLog(OperationLogDTO dto);

    /**
     * 根据UUID更新日志内容
     */
    boolean updateContentByUuid(String uuid, String content, Long updateBy);

    /**
     * 根据UUID逻辑删除作业日志
     */
    boolean deleteByUuid(String uuid, Long updateBy);
}