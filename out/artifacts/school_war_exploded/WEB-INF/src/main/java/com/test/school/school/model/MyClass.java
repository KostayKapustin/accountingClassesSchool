package com.test.school.school.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "class")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyClass implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    Long id;

    @Column(name = "yearStudy", nullable = false)
    int yearStudy;

    @Column(name = "mnemonicCode", nullable = false, unique = true)
    Long mnemonicCode;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    Teacher director;

    @ManyToMany(fetch = FetchType.LAZY)
    List<Student> classStudents;

    @Override
    public MyClass clone() throws CloneNotSupportedException {
        MyClass clone = (MyClass) super.clone();
        if (director != null) {
            clone.director = director.clone();
        }
        clone.classStudents = new ArrayList<>();
        for (var student : classStudents) {
            clone.classStudents.add(student);
        }
        return clone;
    }
}
