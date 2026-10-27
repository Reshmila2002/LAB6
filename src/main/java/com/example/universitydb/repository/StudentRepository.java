package com.example.universitydb.repository;

import com.example.universitydb.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // SELECT ... FROM student WHERE student_code = ?
    Optional<Student> findByStudentCode(String studentCode);

    // WHERE LOWER(full_name) LIKE LOWER('%?%')
    List<Student> findByFullNameContainingIgnoreCase(String text);

    // ORDER BY full_name ASC
    List<Student> findAllByOrderByFullNameAsc();

    // WHERE email = ?
    boolean existsByEmail(String email);

    // WHERE email LIKE '%?'
    long countByEmailEndingWith(String domain);
}
