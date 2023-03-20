package com.test.school.school.repository;

import com.test.school.school.dto.ClassDto;
import com.test.school.school.model.MyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<MyClass, Long> {

    @Query(value = "select * from class c where c.year_study = :yearStudy",
            nativeQuery = true)
    List<MyClass> selectionYearStudy(@Param("yearStudy") int yearStudy);
}
