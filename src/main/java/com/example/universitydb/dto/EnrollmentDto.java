package com.example.universitydb.dto;

import com.example.universitydb.model.Enrollment;

public record EnrollmentDto(
        String studentCode,
        String studentName,
        String courseCode,
        String courseTitle,
        String grade
) {

    public static EnrollmentDto from(Enrollment enrollment) {
        return new EnrollmentDto(
                enrollment.getStudent().getStudentCode(),
                enrollment.getStudent().getFullName(),
                enrollment.getCourse().getCode(),
                enrollment.getCourse().getTitle(),
                enrollment.getGrade()
        );
    }
}
