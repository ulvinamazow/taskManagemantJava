package com.example.taskmanagemant.exception;

public class TaskAlreadyExistsException extends RuntimeException{
    public TaskAlreadyExistsException(String message) {
        super(message);
    }
}
