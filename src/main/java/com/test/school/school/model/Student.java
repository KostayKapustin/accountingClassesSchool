package com.test.school.school.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    Long id;

    @Column(name = "surname", nullable = false)
    String surname;

    @Column(name = "firstName", nullable = false)
    String firstName;

    @Column(name = "patronymic", nullable = false)
    String patronymic;

    @Column(name = "yearBirth", nullable = false)
    int yearBirth;

    @Column(name = "gender", nullable = false)
    String gender;

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}
