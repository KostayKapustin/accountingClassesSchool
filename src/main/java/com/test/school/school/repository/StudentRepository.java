package com.test.school.school.repository;

import com.test.school.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select * from student s where s.surname = :surname",
            nativeQuery = true)
    List<Student> selectionSurname(@Param("surname") String surname);

    @Query(value = "select * from student s where s.first_name = :firstName",
            nativeQuery = true)
    List<Student> selectionFirstName(@Param("firstName") String firstName);

    @Query(value = "select * from student s where s.patronymic = :patronymic",
            nativeQuery = true)
    List<Student> selectionPatronymic(@Param("patronymic") String patronymic);

    @Query(value = "select * from student s where s.year_birth = :yearBirth",
            nativeQuery = true)
    List<Student> selectionYearBirth(@Param("yearBirth") String yearBirth);

    @Query(value = "select * from student s where s.gender = :gender",
            nativeQuery = true)
    List<Student> selectionGender(@Param("gender") String gender);
}
