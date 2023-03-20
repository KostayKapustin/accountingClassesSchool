package com.test.school.school.dto;

import com.test.school.school.model.Student;
import com.test.school.school.model.Teacher;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClassDto {

    @NotNull
    int yearStudy;

    @NotNull
    Long mnemonicCode;

    Teacher director;

    List<Student> classStudents;
}
