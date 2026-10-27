package com.example.universitydb.dto;

/** Interface projection filled from the aliases in EnrollmentRepository's JPQL query. */
public interface CourseEnrollmentCount {

    String getCourseCode();

    String getTitle();

    Long getStudentCount();
}
