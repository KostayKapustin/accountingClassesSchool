package com.test.school.school.mapper;

import com.test.school.school.dto.TeacherDto;
import com.test.school.school.model.Teacher;

public class TeacherMapper {

    public static TeacherDto toTeacherDto(Teacher teacher) {
        return new TeacherDto(teacher.getSurname(), teacher.getFirstName(), teacher.getPatronymic(),
                teacher.getYearBirth(), teacher.getMainSubject());
    }

    public static Teacher toTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setSurname(teacherDto.getSurname());
        teacher.setPatronymic(teacherDto.getPatronymic());
        teacher.setYearBirth(teacherDto.getYearBirth());
        teacher.setMainSubject(teacherDto.getMainSubject());
        return teacher;
    }
}
