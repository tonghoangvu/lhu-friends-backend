package com.tonghoangvu.lhufriendsbackend.service;

import com.tonghoangvu.lhufriendsbackend.common.Const;
import com.tonghoangvu.lhufriendsbackend.exception.AppException;
import com.tonghoangvu.lhufriendsbackend.exception.ErrorCode;
import com.tonghoangvu.lhufriendsbackend.model.StudentFilter;
import com.tonghoangvu.lhufriendsbackend.model.StudentInfo;
import com.tonghoangvu.lhufriendsbackend.repository.CustomStudentRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final @NotNull CustomStudentRepository customStudentRepository;

    public @NotNull Flux<StudentInfo> getStudents(@NotNull StudentFilter studentFilter, int page, int size) {
        if (size > Const.MAX_STUDENTS_PER_REQUEST.getIntValue())
            throw new AppException(HttpStatus.BAD_REQUEST, ErrorCode.REQUEST_TOO_MANY,
                    "Request too much data");
        return customStudentRepository.findAndWithFilterAndPagination(studentFilter, page, size)
                .map(student -> {
                    if (studentFilter.getPhone() == null || studentFilter.getPhone().isEmpty())
                        student.setPhone(null);
                    return new StudentInfo(student);
                });
    }
}
