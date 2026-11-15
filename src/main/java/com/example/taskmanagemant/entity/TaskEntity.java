package com.example.taskmanagemant.entity;

import com.example.taskmanagemant.entity.enums.TaskPriority;
import com.example.taskmanagemant.entity.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "title", length = 30)
    String title;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;

    @Column(name = "task_status")
    @Enumerated(EnumType.STRING)
    TaskStatus taskStatus = TaskStatus.TODO;

    @Column(name = "task_priority")
    @Enumerated(EnumType.STRING)
    TaskPriority taskPriority;

    @Column(name = "task_weight")
    String taskWeight;

    @Column(name = "status")
    Boolean status = true;

    @Column(name = "created_at")
    LocalDateTime createdAt = LocalDateTime.now();

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        taskStatus = TaskStatus.TODO;
    }
}
