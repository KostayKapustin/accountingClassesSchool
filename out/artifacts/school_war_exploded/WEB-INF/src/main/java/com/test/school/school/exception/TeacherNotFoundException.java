package com.test.school.school.exception;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(Long id) {
        super(String.format("Teacher с id=%d не найден!", id));
    }
}
