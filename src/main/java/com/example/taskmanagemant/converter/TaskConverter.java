package com.example.taskmanagemant.converter;

import com.example.taskmanagemant.dto.request.AddTaskRequestDto;
import com.example.taskmanagemant.dto.request.UpdateTaskRequestDto;
import com.example.taskmanagemant.dto.response.AllTaskResponseDto;
import com.example.taskmanagemant.dto.response.TaskResponseDto;
import com.example.taskmanagemant.entity.TaskEntity;
import com.example.taskmanagemant.entity.enums.TaskStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskConverter {

    public TaskResponseDto toTaskResponseDtoFromEntity(TaskEntity taskEntity) {
        return new TaskResponseDto(
                taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getTaskStatus(),
                taskEntity.getTaskPriority(),
                taskEntity.getTaskWeight(),
                taskEntity.getCreatedAt()
        );
    }

    public AllTaskResponseDto toAllTasksResponseDtoFromEntity(TaskEntity taskEntity) {
        return new AllTaskResponseDto(
                taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getTaskStatus()
        );
    }

    public TaskEntity toEntityFromAddTaskRequestDto(AddTaskRequestDto requestDto) {
        TaskEntity entity = new TaskEntity();
        entity.setTitle(requestDto.getTitle());
        entity.setDescription(requestDto.getDescription());
        entity.setTaskStatus(TaskStatus.TODO);
        entity.setTaskPriority(requestDto.getTaskPriority());
        entity.setStatus(true);
        entity.setCreatedAt(LocalDateTime.now());

        return entity;
    }

    public TaskEntity toEntityFromUpdateTaskRequestDto(TaskEntity entity, UpdateTaskRequestDto requestDto) {
        entity.setTitle(requestDto.getTitle());
        entity.setDescription(requestDto.getDescription());
        entity.setTaskStatus(requestDto.getTaskStatus());
        entity.setTaskPriority(requestDto.getTaskPriority());
        entity.setTaskWeight(requestDto.getTaskWeight());

        return entity;
    }
}
