package com.test.school.school.service;

import com.test.school.school.dto.ClassDto;
import com.test.school.school.dto.UpdateClassDto;

import java.util.List;

public interface ClassService {
    List<ClassDto> receiveClass();

    ClassDto addClass(ClassDto classDto);

    ClassDto addClassAndTeacher(Long classId, Long teacherId);

    ClassDto receiveClassById(Long id);

    ClassDto addClassAndStudent(Long classId, Long studentId);

    ClassDto updateClass(Long classId, UpdateClassDto updateClassDto);

    void deleteAllClass();

    void deleteClass(Long id);

    List<ClassDto> getSortedClass(String field);

    List<ClassDto> getSelectionYearStudyClass(int field);

}
