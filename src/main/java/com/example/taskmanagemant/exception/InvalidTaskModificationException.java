package com.example.taskmanagemant.exception;

public class InvalidTaskModificationException extends RuntimeException{
    public InvalidTaskModificationException(String message) {
        super(message);
    }
}
