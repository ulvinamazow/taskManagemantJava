package com.example.taskmanagemant.dto.response;

import com.example.taskmanagemant.entity.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class AllTaskResponseDto {
    Integer id;
    String title;
    TaskStatus taskStatus;
}
