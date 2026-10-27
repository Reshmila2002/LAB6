package com.example.universitydb.repository;

import com.example.universitydb.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByCode(String code);

    // Loads a department and all its lecturers in a single select statement.
    @Query("SELECT d FROM Department d LEFT JOIN FETCH d.lecturers WHERE d.code = :code")
    Optional<Department> findWithLecturers(@Param("code") String code);
}
