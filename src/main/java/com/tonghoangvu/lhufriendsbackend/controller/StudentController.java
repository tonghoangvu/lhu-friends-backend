package com.tonghoangvu.lhufriendsbackend.controller;

import com.tonghoangvu.lhufriendsbackend.model.StudentFilter;
import com.tonghoangvu.lhufriendsbackend.model.StudentInfo;
import com.tonghoangvu.lhufriendsbackend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<Flux<StudentInfo>> getStudents(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestBody StudentFilter studentFilter) {
        return ResponseEntity.ok(studentService.getStudents(studentFilter, page, size));
    }
}
