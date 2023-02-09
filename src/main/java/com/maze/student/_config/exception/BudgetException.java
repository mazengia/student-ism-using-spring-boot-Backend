package com.maze.student._config.exception;

import lombok.Data;

@Data
public class BudgetException extends RuntimeException {
    private String message;

    public BudgetException(String message) {
        this.message = message;
    }
}
