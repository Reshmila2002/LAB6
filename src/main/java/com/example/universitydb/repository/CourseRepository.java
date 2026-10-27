package com.example.universitydb.repository;

import com.example.universitydb.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByCode(String code);

    List<Course> findByCreditsGreaterThanEqual(Integer credits);

    List<Course> findByTitleContainingIgnoreCase(String text);

    // Property path Course -> lecturer -> name.
    List<Course> findByLecturer_Name(String lecturerName);

    // Property path Course -> lecturer -> department -> name.
    List<Course> findByLecturer_Department_Name(String departmentName);
}
