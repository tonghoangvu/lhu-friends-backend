package com.tonghoangvu.lhufriendsbackend.model;

import com.tonghoangvu.lhufriendsbackend.entity.Student;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class StudentInfo {
    private String studentId;
    private String fullName;
    private String birthday;
    private String gender;
    private String placeOfBirth;
    private String ethnic;
    private String nationality;
    private String classId;
    private String image;
    private String avatar;
    private String userName;
    private String email;
    private String phone;
    private String groupName;
    private String facebook;

    public StudentInfo(@NotNull Student student) {
        this.studentId = student.getStudentId();
        this.fullName = student.getFullName();
        this.birthday = student.getBirthday();
        this.gender = student.getGender();
        this.placeOfBirth = student.getPlaceOfBirth();
        this.ethnic = student.getEthnic();
        this.nationality = student.getNationality();
        this.classId = student.getClassId();
        this.image = student.getImage();
        this.avatar = student.getAvatar();
        this.userName = student.getUserName();
        this.email = student.getEmail();
        this.phone = student.getPhone();
        this.groupName = student.getGroupName();
        this.facebook = student.getFacebook();
    }
}
