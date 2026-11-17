package com.example.taskmanagemant.controller;


import com.example.taskmanagemant.dto.request.AddTaskRequestDto;
import com.example.taskmanagemant.dto.request.UpdateTaskRequestDto;
import com.example.taskmanagemant.dto.response.AllTaskResponseDto;
import com.example.taskmanagemant.dto.response.TaskResponseDto;
import com.example.taskmanagemant.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<AllTaskResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TaskResponseDto getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public void saveTask(@RequestBody AddTaskRequestDto requestDto) {
        service.saveTask(requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }
    @PutMapping("/{id}")
    public void updateTask(@PathVariable Integer id, @RequestBody UpdateTaskRequestDto requestDto) {
        service.updateTask(id, requestDto);
    }
}
