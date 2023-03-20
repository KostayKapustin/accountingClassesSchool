package com.test.school.school.exception;

public class MyClassNotFoundException extends RuntimeException {
    public MyClassNotFoundException(Long id) {
        super(String.format("Class с id=%d не найден!", id));
    }
}
