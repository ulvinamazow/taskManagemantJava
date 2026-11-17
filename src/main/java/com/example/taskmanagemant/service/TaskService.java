package com.example.taskmanagemant.service;

import com.example.taskmanagemant.converter.TaskConverter;
import com.example.taskmanagemant.dto.request.UpdateTaskRequestDto;
import com.example.taskmanagemant.dto.response.AllTaskResponseDto;
import com.example.taskmanagemant.dto.response.TaskResponseDto;
import com.example.taskmanagemant.entity.TaskEntity;
import com.example.taskmanagemant.entity.enums.TaskStatus;
import com.example.taskmanagemant.exception.InvalidTaskModificationException;
import com.example.taskmanagemant.exception.TaskAlreadyDeletedException;
import com.example.taskmanagemant.exception.TaskAlreadyExistsException;
import com.example.taskmanagemant.exception.TaskNotFoundException;
import com.example.taskmanagemant.repository.TaskRepository;
import com.example.taskmanagemant.dto.request.AddTaskRequestDto;

import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    private final TaskRepository repository;
    private final TaskConverter converter;

    public TaskService(TaskRepository repository, TaskConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public List<AllTaskResponseDto> getAll() {
        return repository.findAll().stream()
                .filter(entity -> entity.getStatus().equals(true))
                .map(converter::toAllTasksResponseDtoFromEntity)
                .collect(Collectors.toList());
    }

    public TaskResponseDto getById(Integer id) {
        TaskEntity taskEntity = getEntityGetByID(id);
        return converter.toTaskResponseDtoFromEntity(taskEntity);
    }

    public void saveTask(AddTaskRequestDto requestDto) {
        if (repository.existsByTitleIgnoreCase(requestDto.getTitle())) {
            throw new TaskAlreadyExistsException("Task already exists");
        }
        repository.save(converter.toEntityFromAddTaskRequestDto(requestDto));
    }

    public void deleteById(Integer id) {
        TaskEntity taskEntity = getEntityGetByID(id);
        if(taskEntity.getStatus().equals(false)) {
            throw new TaskAlreadyDeletedException("Task allready deleted");
        }
        taskEntity.setStatus(false);
        repository.save(taskEntity);
    }

    public void updateTask(Integer id, UpdateTaskRequestDto requestDto) {
        TaskEntity entity = getEntityGetByID(id);
        if (repository.existsByTitleAndIdNot(requestDto.getTitle(), id)) {
            throw new InvalidTaskModificationException("Invalid task modification");
        }

        if (entity.getStatus().equals(false) || entity.getStatus().equals(TaskStatus.DONE)) {
            throw new InvalidTaskModificationException("Invalid task modification");
        }

        repository.save(converter.toEntityFromUpdateTaskRequestDto(entity, requestDto));
    }

    private TaskEntity getEntityGetByID(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
    }
}
