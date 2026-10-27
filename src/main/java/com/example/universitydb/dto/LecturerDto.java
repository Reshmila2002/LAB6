package com.example.universitydb.dto;

import com.example.universitydb.model.Lecturer;

public record LecturerDto(String name, String email, String department) {

    public static LecturerDto from(Lecturer lecturer) {
        return new LecturerDto(
                lecturer.getName(),
                lecturer.getEmail(),
                lecturer.getDepartment().getName()
        );
    }
}
