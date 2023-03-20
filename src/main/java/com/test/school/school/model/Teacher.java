package com.test.school.school.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Table(name = "teacher")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Teacher implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    Long id;

    @Column(name = "surname", nullable = false)
    String surname;

    @Column(name = "firstName", nullable = false)
    String firstName;

    @Column(name = "patronymic", nullable = false)
    String patronymic;

    @Column(name = "yearBirth", nullable = false)
    int yearBirth;

    @Column(name = "mainSubject", nullable = false)
    String mainSubject;

    @Override
    public Teacher clone() throws CloneNotSupportedException {
        return (Teacher) super.clone();
    }

}
