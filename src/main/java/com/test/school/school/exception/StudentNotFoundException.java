package com.test.school.school.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super(String.format("Student с id=%d не найден!", id));
    }
}
