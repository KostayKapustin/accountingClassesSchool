package com.test.school.school.service;

import com.test.school.school.dto.StudentDto;
import com.test.school.school.dto.UpdateStudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> receiveStudent();

    StudentDto receiveStudentById(Long id);

    StudentDto addStudent(StudentDto studentDto);

    StudentDto updateStudent(Long studentId, UpdateStudentDto updateStudentDto);

    void deleteAllStudent();

    void deleteStudentById(Long id);

    List<StudentDto> getSortedStudent(String field);

    List<StudentDto> getSelectionSurnameStudent(String field);

    List<StudentDto> getSelectionFirstNameStudent(String field);

    List<StudentDto> getSelectionPatronymicStudent(String field);

    List<StudentDto> getSelectionYearBirthStudent(String field);

    List<StudentDto> getSelectionGenderStudent(String field);
}
