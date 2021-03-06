package com.tonghoangvu.lhufriendsbackend.controller;

import com.tonghoangvu.lhufriendsbackend.model.StudentFilter;
import com.tonghoangvu.lhufriendsbackend.model.StudentInfo;
import com.tonghoangvu.lhufriendsbackend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final @NotNull StudentService studentService;

    @PostMapping("/")
    @CrossOrigin(origins = "*")
    public @NotNull Flux<StudentInfo> getStudents(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestBody @NotNull StudentFilter studentFilter) {
        return studentService.getStudents(studentFilter, page, size);
    }

    @PostMapping("/random")
    @CrossOrigin(origins = "*")
    public @NotNull Flux<StudentInfo> getRandomStudents(
            @RequestParam(value = "size", defaultValue = "3") int size,
            @RequestBody @NotNull StudentFilter studentFilter) {
        return studentService.getRandomStudents(studentFilter, size);
    }
}
