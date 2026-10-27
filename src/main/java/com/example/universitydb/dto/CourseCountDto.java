package com.example.universitydb.dto;

public record CourseCountDto(String courseCode, String title, Long studentCount) {

    public static CourseCountDto from(CourseEnrollmentCount projection) {
        return new CourseCountDto(
                projection.getCourseCode(),
                projection.getTitle(),
                projection.getStudentCount()
        );
    }
}
