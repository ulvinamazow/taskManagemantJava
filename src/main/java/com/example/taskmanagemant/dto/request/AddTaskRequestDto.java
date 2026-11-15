package com.example.taskmanagemant.dto.request;

import com.example.taskmanagemant.entity.enums.TaskPriority;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddTaskRequestDto {
    String title;
    String description;
    TaskPriority taskPriority;
    String taskWeight;
}
