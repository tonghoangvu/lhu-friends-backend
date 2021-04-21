package com.tonghoangvu.lhufriendsbackend.repository;

import com.tonghoangvu.lhufriendsbackend.entity.Student;
import com.tonghoangvu.lhufriendsbackend.model.StudentFilter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class CustomStudentRepository {
    private final @NotNull ReactiveMongoOperations mongoOperations;

    private @NotNull Criteria buildStudentFilterCriteria(@NotNull StudentFilter studentFilter) {
        Criteria criteria = new Criteria();

        // Regex match fields
        if (studentFilter.getStudentId() != null)
            criteria.and("studentId").regex(studentFilter.getStudentId(), "i");
        if (studentFilter.getFullName() != null)
            criteria.and("fullName").regex(studentFilter.getFullName(), "i");
        if (studentFilter.getBirthday() != null)
            criteria.and("birthday").regex(studentFilter.getBirthday(), "i");
        if (studentFilter.getGender() != null)
            criteria.and("gender").regex(studentFilter.getGender(), "i");
        if (studentFilter.getPlaceOfBirth() != null)
            criteria.and("placeOfBirth").regex(studentFilter.getPlaceOfBirth(), "i");
        if (studentFilter.getEthnic() != null)
            criteria.and("ethnic").regex(studentFilter.getEthnic(), "i");
        if (studentFilter.getNationality() != null)
            criteria.and("nationality").regex(studentFilter.getNationality(), "i");
        if (studentFilter.getClassId() != null)
            criteria.and("classId").regex(studentFilter.getClassId(), "i");
        if (studentFilter.getFacebook() != null)
            criteria.and("facebook").regex(studentFilter.getFacebook(), "i");
        if (studentFilter.getEmail() != null)
            criteria.and("email").regex(studentFilter.getEmail(), "i");
        if (studentFilter.getPhone() != null)
            criteria.and("phone").regex(studentFilter.getPhone(), "i");

        return criteria;
    }

    public @NotNull Flux<Student> findTopRandomWithFilter(@NotNull StudentFilter studentFilter, int size) {
        MatchOperation matchOp = Aggregation.match(buildStudentFilterCriteria(studentFilter));
        SampleOperation sampleOp = Aggregation.sample(size);
        Aggregation aggregation = Aggregation.newAggregation(matchOp, sampleOp);
        return mongoOperations.aggregate(aggregation, "students", Student.class);
    }

    public @NotNull Flux<Student> findAllWithFilterAndPagination(
            @NotNull StudentFilter studentFilter, int page, int size) {
        Query query = new Query()
                .with(Sort.by("studentId").descending())
                .with(PageRequest.of(page, size))
                .addCriteria(buildStudentFilterCriteria(studentFilter));
        return mongoOperations.find(query, Student.class);
    }
}
