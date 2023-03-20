package com.test.school.school.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler({MyClassNotFoundException.class, TeacherNotFoundException.class,
            StudentNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(final RuntimeException e) {
        log.info(HttpStatus.BAD_REQUEST + ": " + e.getMessage());
        return new ErrorResponse(e.getClass().toString(), e.getMessage(), "Элемент не найден",
                HttpStatus.NOT_FOUND.toString());
    }
}