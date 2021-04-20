package com.tonghoangvu.lhufriendsbackend.repository;

import com.tonghoangvu.lhufriendsbackend.entity.Student;
import com.tonghoangvu.lhufriendsbackend.model.StudentFilter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class CustomStudentRepository {
    private final @NotNull ReactiveMongoOperations mongoOperations;

    private @NotNull Criteria regexCriteria(@NotNull String field, @NotNull String value) {
        return Criteria.where(field).regex(value, "i");
    }

    public @NotNull Flux<Student> findAndWithFilterAndPagination(
            @NotNull StudentFilter studentFilter, int page, int size) {
        // Create query
        Query query = new Query()
                .with(Sort.by("studentId").descending())
                .with(PageRequest.of(page, size));

        // Exact match fields
        if (studentFilter.getGender() != null)
            query.addCriteria(Criteria.where("gender").is(studentFilter.getGender()));

        // Regex match fields
        if (studentFilter.getStudentId() != null)
            query.addCriteria(regexCriteria("studentId", studentFilter.getStudentId()));
        if (studentFilter.getFullName() != null)
            query.addCriteria(regexCriteria("fullName", studentFilter.getFullName()));
        if (studentFilter.getBirthday() != null)
            query.addCriteria(regexCriteria("birthday", studentFilter.getBirthday()));
        if (studentFilter.getPlaceOfBirth() != null)
            query.addCriteria(regexCriteria("placeOfBirth", studentFilter.getPlaceOfBirth()));
        if (studentFilter.getEthnic() != null)
            query.addCriteria(regexCriteria("ethnic", studentFilter.getEthnic()));
        if (studentFilter.getNationality() != null)
            query.addCriteria(regexCriteria("nationality", studentFilter.getNationality()));
        if (studentFilter.getClassId() != null)
            query.addCriteria(regexCriteria("classId", studentFilter.getClassId()));
        if (studentFilter.getFacebook() != null)
            query.addCriteria(regexCriteria("facebook", studentFilter.getFacebook()));
        if (studentFilter.getEmail() != null)
            query.addCriteria(regexCriteria("email", studentFilter.getEmail()));
        if (studentFilter.getPhone() != null)
            query.addCriteria(regexCriteria("phone", studentFilter.getPhone()));

        // Start query
        return mongoOperations.find(query, Student.class);
    }
}
