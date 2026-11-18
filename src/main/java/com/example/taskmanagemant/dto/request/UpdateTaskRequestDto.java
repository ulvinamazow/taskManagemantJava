package com.example.taskmanagemant.dto.request;

import com.example.taskmanagemant.entity.enums.TaskPriority;
import com.example.taskmanagemant.entity.enums.TaskStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateTaskRequestDto {
    @NotNull(message = "Title can not be null")
    String title;
    @NotEmpty(message = "Description can not be empty")
    String description;
    @NotNull(message = "Status can not be null")
    TaskStatus taskStatus = TaskStatus.TODO;
    @NotNull(message = "Priority can not be null")
    TaskPriority taskPriority;
    @Min(value = 1, message = "Weight must be least 1")
    @Max(value = 10, message = "Weight must be most 10")
    Short taskWeight;
}
