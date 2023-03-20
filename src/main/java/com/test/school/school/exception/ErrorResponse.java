package com.test.school.school.exception;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class ErrorResponse {
    private final List<String> errors;
    private final String message;
    private final String reason;
    private final String status;

    public ErrorResponse(List<String> errors, String message, String reason, String status) {
        this.errors = errors;
        this.message = message;
        this.reason = reason;
        this.status = status;
    }

    public ErrorResponse(String error, String message, String reason, String status) {
        errors = Collections.singletonList(error);
        this.message = message;
        this.reason = reason;
        this.status = status;
    }
}

