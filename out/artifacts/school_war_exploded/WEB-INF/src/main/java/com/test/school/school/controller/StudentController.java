package com.test.school.school.controller;

import com.test.school.school.dto.StudentDto;
import com.test.school.school.dto.UpdateStudentDto;
import com.test.school.school.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentController {

    final StudentService studentService;

    @GetMapping
    public List<StudentDto> receiveStudent() {
        return studentService.receiveStudent();
    }

    @GetMapping("/{id}")
    public StudentDto receiveStudentById(@PathVariable Long id) {
        return studentService.receiveStudentById(id);
    }

    @PostMapping
    public StudentDto addStudent(@Valid @RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);
    }

    @PatchMapping("/update/{studentId}")
    public StudentDto updateClass(@PathVariable Long studentId, @Valid @RequestBody UpdateStudentDto updateStudentDto) {
        return studentService.updateStudent(studentId, updateStudentDto);
    }

    @DeleteMapping
    public void deleteAllStudent() {
        studentService.deleteAllStudent();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping("/sorted/{field}")
    public List<StudentDto> getSortedStudent(@PathVariable String field) {
        return studentService.getSortedStudent(field);
    }

    @GetMapping("/select/surname/{field}")
    public List<StudentDto> getSelectionSurnameStudent(@PathVariable String field) {
        return studentService.getSelectionSurnameStudent(field);
    }

    @GetMapping("/select/firstName/{field}")
    public List<StudentDto> getSelectionFirstNameStudent(@PathVariable String field) {
        return studentService.getSelectionFirstNameStudent(field);
    }

    @GetMapping("/select/patronymic/{field}")
    public List<StudentDto> getSelectionPatronymicStudent(@PathVariable String field) {
        return studentService.getSelectionPatronymicStudent(field);
    }

    @GetMapping("/select/yearBirth/{field}")
    public List<StudentDto> getSelectionYearBirthStudent(@PathVariable String field) {
        return studentService.getSelectionYearBirthStudent(field);
    }

    @GetMapping("/select/gender/{field}")
    public List<StudentDto> getSelectionGenderStudent(@PathVariable String field) {
        return studentService.getSelectionGenderStudent(field);
    }
}
