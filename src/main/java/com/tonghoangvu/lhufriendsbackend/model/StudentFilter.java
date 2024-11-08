package com.tonghoangvu.lhufriendsbackend.model;

import lombok.Data;

@Data
public class StudentFilter {
    private String studentId;
    private String fullName;
    private String birthday;
    private String gender;
    private String placeOfBirth;
    private String ethnic;
    private String nationality;
    private String classId;
    private String email;
    private String phone;
    private String facebook;
}
