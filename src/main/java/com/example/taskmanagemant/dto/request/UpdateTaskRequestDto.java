package com.example.taskmanagemant.dto.request;

import com.example.taskmanagemant.entity.enums.TaskPriority;
import com.example.taskmanagemant.entity.enums.TaskStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateTaskRequestDto {
    String title;
    String description;
    TaskStatus taskStatus = TaskStatus.TODO;
    TaskPriority taskPriority;
    String taskWeight;
}
