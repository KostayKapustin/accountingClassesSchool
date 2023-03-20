package com.test.school.school.controller;

import com.test.school.school.dto.TeacherDto;
import com.test.school.school.dto.UpdateTeacherDto;
import com.test.school.school.service.TeacherService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherController {

    final TeacherService teacherService;


    @GetMapping
    public List<TeacherDto> receiveTeacher() {
        return teacherService.receiveTeacher();
    }

    @GetMapping("/{id}")
    public TeacherDto receiveTeacheryId(@PathVariable Long id) {
        return teacherService.receiveTeacherById(id);
    }

    @PostMapping
    public TeacherDto addTeacher(@Valid @RequestBody TeacherDto teacherDto) {
        return teacherService.addTeacher(teacherDto);
    }

    @PatchMapping("/update/{teacherId}")
    public TeacherDto updateTeacher(@PathVariable Long teacherId,
                                    @Valid @RequestBody UpdateTeacherDto updateTeacherDto) {
        return teacherService.updateTeacher(teacherId, updateTeacherDto);
    }

    @DeleteMapping
    public void deleteAllTeacher() {
        teacherService.deleteAllTeacher();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
    }

    @GetMapping("/sorted/{field}")
    public List<TeacherDto> getSortedTeacher(@PathVariable String field) {
        return teacherService.getSortedTeacher(field);
    }

    @GetMapping("/select/surname/{field}")
    public List<TeacherDto> getSelectionSurnameTeacher(@PathVariable String field) {
        return teacherService.getSelectionSurnameTeacher(field);
    }

    @GetMapping("/select/firstName/{field}")
    public List<TeacherDto> getSelectionFirstNameTeacher(@PathVariable String field) {
        return teacherService.getSelectionFirstNameTeacher(field);
    }

    @GetMapping("/select/patronymic/{field}")
    public List<TeacherDto> getSelectionPatronymicTeacher(@PathVariable String field) {
        return teacherService.getSelectionPatronymicTeacher(field);
    }

    @GetMapping("/select/yearBirth/{field}")
    public List<TeacherDto> getSelectionYearBirthTeacher(@PathVariable String field) {
        return teacherService.getSelectionYearBirthTeacher(field);
    }

    @GetMapping("/select/gender/{field}")
    public List<TeacherDto> getSelectionMainSubjectTeacher(@PathVariable String field) {
        return teacherService.getSelectionMainSubjectTeacher(field);
    }
}
