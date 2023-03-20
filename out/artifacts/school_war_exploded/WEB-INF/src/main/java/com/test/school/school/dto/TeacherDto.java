package com.test.school.school.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherDto {

    @NotNull
    String surname;

    @NotNull
    String firstName;

    @NotNull
    String patronymic;

    @NotNull
    int yearBirth;

    @NotNull
    String mainSubject;
}
