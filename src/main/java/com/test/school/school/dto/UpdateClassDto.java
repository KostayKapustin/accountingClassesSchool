package com.test.school.school.dto;

import com.test.school.school.model.Student;
import com.test.school.school.model.Teacher;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateClassDto {

    int yearStudy;

    Long mnemonicCode;

    Teacher director;

    List<Student> classStudents;
}