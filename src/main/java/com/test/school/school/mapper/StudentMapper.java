package com.test.school.school.mapper;

import com.test.school.school.dto.StudentDto;
import com.test.school.school.model.Student;

public class StudentMapper {

    public static StudentDto toStudentDto(Student student) {
        return new StudentDto(student.getSurname(), student.getFirstName(), student.getPatronymic(),
                student.getYearBirth(), student.getGender());
    }

    public static Student toStudent(StudentDto studentDto) {
        Student student =new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setSurname(studentDto.getSurname());
        student.setPatronymic(studentDto.getPatronymic());
        student.setYearBirth(studentDto.getYearBirth());
        student.setGender(studentDto.getGender());
        return student;
    }
}
