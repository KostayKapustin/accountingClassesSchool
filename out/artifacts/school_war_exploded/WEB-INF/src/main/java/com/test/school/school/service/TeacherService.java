package com.test.school.school.service;

import com.test.school.school.dto.TeacherDto;
import com.test.school.school.dto.UpdateTeacherDto;

import java.util.List;

public interface TeacherService {
    List<TeacherDto> receiveTeacher();

    TeacherDto receiveTeacherById(Long id);

    TeacherDto addTeacher(TeacherDto teacherDto);

    TeacherDto updateTeacher(Long teacherId, UpdateTeacherDto updateTeacherDto);

    void deleteAllTeacher();

    void deleteTeacherById(Long id);

    List<TeacherDto> getSortedTeacher(String field);

    List<TeacherDto> getSelectionSurnameTeacher(String field);

    List<TeacherDto> getSelectionFirstNameTeacher(String field);

    List<TeacherDto> getSelectionPatronymicTeacher(String field);

    List<TeacherDto> getSelectionYearBirthTeacher(String field);

    List<TeacherDto> getSelectionMainSubjectTeacher(String field);

}
