package com.test.school.school.controller;

import com.test.school.school.dto.ClassDto;
import com.test.school.school.dto.UpdateClassDto;
import com.test.school.school.service.ClassService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/class")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClassController {

    private final ClassService classService;

    @GetMapping
    public List<ClassDto> receiveClass() {
        return classService.receiveClass();
    }

    @GetMapping("/{id}")
    public ClassDto receiveClassById(@PathVariable Long id) {
        return classService.receiveClassById(id);
    }

    @PostMapping
    public ClassDto addClass(@Valid @RequestBody ClassDto classDto) {
        return classService.addClass(classDto);
    }

    @PostMapping("/{classId}/teacher/{teacherId}")
    public ClassDto addClassAndTeacher(@PathVariable Long classId, @PathVariable Long teacherId) {
        return classService.addClassAndTeacher(classId, teacherId);
    }

    @PostMapping("/{classId}/student/{studetnId}")
    public ClassDto addClassAndStudent(@PathVariable Long classId, @PathVariable Long studetnId) {
        return classService.addClassAndStudent(classId, studetnId);
    }

    @PatchMapping("/update/{classId}")
    public ClassDto updateClass(@PathVariable Long classId, @Valid @RequestBody UpdateClassDto updateClassDto) {
        return classService.updateClass(classId, updateClassDto);
    }

    @DeleteMapping
    public void deleteAllClass() {
        classService.deleteAllClass();
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
    }

    @GetMapping("/sorted/{field}")
    public List<ClassDto> getSortedClass(@PathVariable String field) {
        return classService.getSortedClass(field);
    }

    @GetMapping("/select/yearStudy/{field}")
    public List<ClassDto> getSelectionYearStudyClass(@PathVariable int field) {
        return classService.getSelectionYearStudyClass(field);
    }
}
