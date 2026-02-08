package com.geo.dsp.module.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geo.dsp.module.project.dto.CollectTaskDTO;
import com.geo.dsp.module.project.entity.CollectTask;
import com.geo.dsp.module.project.mapper.CollectTaskMapper;
import com.geo.dsp.module.project.service.CollectTaskService;
import com.geo.dsp.module.project.vo.CollectTaskVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * 采集任务表 服务实现类
 */
@Slf4j
@Service
public class CollectTaskServiceImpl extends ServiceImpl<CollectTaskMapper, CollectTask> implements CollectTaskService {

    @Autowired
    private CollectTaskMapper collectTaskMapper;

    @Override
    public CollectTaskVO getTaskByUuid(String uuid) {
        CollectTask task = collectTaskMapper.selectByUuid(uuid);
        if (task == null || task.getIsDel()) {
            return null;
        }
        return toVO(task);
    }

    @Override
    public List<CollectTaskVO> listByProjectUuid(String projectUuid) {
        List<CollectTask> tasks = collectTaskMapper.listByProjectUuid(projectUuid);
        return tasks.stream().map(this::toVO).collect(Collectors.toList());
    }

    @Override
    public List<CollectTaskVO> listByOperatorUuid(String operatorUuid) {
        List<CollectTask> tasks = collectTaskMapper.listByOperatorUuid(operatorUuid);
        return tasks.stream().map(this::toVO).collect(Collectors.toList());
    }

    @Override
    public List<CollectTaskVO> listByStatus(Integer status) {
        List<CollectTask> tasks = collectTaskMapper.listByStatus(status);
        return tasks.stream().map(this::toVO).collect(Collectors.toList());
    }

    @Override
    public boolean createTask(CollectTaskDTO dto) {
        try {
            CollectTask task = new CollectTask();
            task.setUuid(UUID.randomUUID().toString());
            task.setProjectId(dto.getProjectId());
            task.setMethodId(dto.getMethodId());
            task.setTaskName(dto.getTaskName());
            task.setStartTime(dto.getStartTime());
            task.setExpectEndTime(dto.getExpectEndTime());
            task.setOperatorId(dto.getOperatorId());
            task.setStatus(dto.getStatus() != null ? dto.getStatus() : 0);
            task.setCreateBy(dto.getOperatorId());
            task.setCreateTime(LocalDateTime.now());
            task.setNote(dto.getNote());
            task.setIsDel(false);

            int result = collectTaskMapper.insert(task);
            log.info("创建采集任务成功，UUID：{}", task.getUuid());
            return result > 0;
        } catch (Exception e) {
            log.error("创建采集任务失败", e);
            return false;
        }
    }

    @Override
    public boolean updateTask(String uuid, CollectTaskDTO dto) {
        try {
            CollectTask task = new CollectTask();
            task.setUuid(uuid);
            task.setTaskName(dto.getTaskName());
            task.setExpectEndTime(dto.getExpectEndTime());
            task.setOperatorId(dto.getOperatorId());
            task.setStatus(dto.getStatus());
            task.setNote(dto.getNote());
            task.setUpdateTime(LocalDateTime.now());
            task.setUpdateBy(dto.getOperatorId());

            int result = collectTaskMapper.updateByUuid(task);
            log.info("更新采集任务成功，UUID：{}", uuid);
            return result > 0;
        } catch (Exception e) {
            log.error("更新采集任务失败，UUID：{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean updateTaskStatus(String uuid, Integer status, Long updateBy) {
        try {
            int result = collectTaskMapper.updateStatusByUuid(uuid, status, updateBy);
            log.info("更新采集任务状态成功，UUID：{}，状态：{}", uuid, status);
            return result > 0;
        } catch (Exception e) {
            log.error("更新采集任务状态失败，UUID：{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean deleteTask(String uuid, Long updateBy) {
        try {
            int result = collectTaskMapper.deleteByUuid(uuid, updateBy);
            log.info("删除采集任务成功，UUID：{}", uuid);
            return result > 0;
        } catch (Exception e) {
            log.error("删除采集任务失败，UUID：{}", uuid, e);
            return false;
        }
    }

    @Override
    public boolean batchDeleteTask(List<String> uuids, Long updateBy) {
        try {
            int successCount = 0;
            for (String uuid : uuids) {
                if (deleteTask(uuid, updateBy)) {
                    successCount++;
                }
            }
            log.info("批量删除采集任务成功，共{}个，成功{}个", uuids.size(), successCount);
            return successCount == uuids.size();
        } catch (Exception e) {
            log.error("批量删除采集任务失败", e);
            return false;
        }
    }

    /**
     * Entity 转 VO
     */
    private CollectTaskVO toVO(CollectTask task) {
        CollectTaskVO vo = new CollectTaskVO();
        vo.setId(task.getId());
        vo.setUuid(task.getUuid());
        vo.setProjectId(task.getProjectId());
        vo.setMethodId(task.getMethodId());
        vo.setTaskName(task.getTaskName());
        vo.setStartTime(task.getStartTime());
        vo.setExpectEndTime(task.getExpectEndTime());
        vo.setActualEnTime(task.getActualEndTime());
        vo.setOperatorId(task.getOperatorId());
        vo.setStatus(task.getStatus());
        vo.setCreateTime(task.getCreateTime());
        vo.setUpdateTime(task.getUpdateTime());
        vo.setNote(task.getNote());
        return vo;
    }
}