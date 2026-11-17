package com.example.taskmanagemant.exception;

public class TaskAlreadyDeletedException extends RuntimeException {
    public TaskAlreadyDeletedException(String message) {
        super(message);
    }
}
