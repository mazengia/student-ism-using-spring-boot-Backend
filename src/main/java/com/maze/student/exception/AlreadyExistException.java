package com.maze.student.exception;

import lombok.Data;

@Data
public class AlreadyExistException extends RuntimeException {
    private String message;

    public AlreadyExistException(String message) {
        this.message = message;
    }
}
