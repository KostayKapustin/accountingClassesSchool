package com.test.school.school.repository;

import com.test.school.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface  TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query(value = "select * from teacher t where t.surname = :surname",
            nativeQuery = true)
    List<Teacher> selectionSurname(@Param("surname") String surname);

    @Query(value = "select * from teacher t where t.first_name = :firstName",
            nativeQuery = true)
    List<Teacher> selectionFirstName(@Param("firstName") String firstName);

    @Query(value = "select * from teacher t where t.patronymic = :patronymic",
            nativeQuery = true)
    List<Teacher> selectionPatronymic(@Param("patronymic") String patronymic);

    @Query(value = "select * from teacher t where t.year_birth = :yearBirth",
            nativeQuery = true)
    List<Teacher> selectionYearBirth(@Param("yearBirth") String yearBirth);

    @Query(value = "select * from teacher t where t.main_subject = :mainSubject",
            nativeQuery = true)
    List<Teacher> selectionMainSubject(@Param("mainSubject") String mainSubject);
}
