package com.example.universitydb.repository;

import com.example.universitydb.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

    Optional<Lecturer> findByEmail(String email);

    // The underscore walks through Lecturer.department.code.
    List<Lecturer> findByDepartment_Code(String departmentCode);
}
