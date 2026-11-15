package com.example.taskmanagemant.dto.response;

import com.example.taskmanagemant.entity.enums.TaskPriority;
import com.example.taskmanagemant.entity.enums.TaskStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class TaskResponseDto {
    Integer id;
    String title;
    String description;
    TaskStatus taskStatus = TaskStatus.TODO;
    TaskPriority taskPriority;
    String taskWeight;
    Boolean status = true;
    LocalDateTime createdAt = LocalDateTime.now();

    public TaskResponseDto(Integer id, String title, String description, TaskStatus taskStatus, TaskPriority taskPriority, String taskWeight, LocalDateTime createdAt) {


    }
}
