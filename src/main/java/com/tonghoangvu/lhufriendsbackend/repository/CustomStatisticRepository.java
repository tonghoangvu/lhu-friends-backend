package com.tonghoangvu.lhufriendsbackend.repository;

import com.tonghoangvu.lhufriendsbackend.model.statistic.GenderStatistic;
import com.tonghoangvu.lhufriendsbackend.model.statistic.LastnameStatistic;
import com.tonghoangvu.lhufriendsbackend.model.statistic.NationalityStatistic;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Repository
@RequiredArgsConstructor
public class CustomStatisticRepository {
    private final @NotNull ReactiveMongoOperations mongoOperations;

    public @NotNull Flux<LastnameStatistic> statisticLastname() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.addFields()
                        .addFieldWithValue("name",
                                new Document("$split", Arrays.asList("$fullName", " ")))
                        .build(),
                Aggregation.addFields()
                        .addFieldWithValue("lastName",
                                new Document("$arrayElemAt", Arrays.asList("$name", 0)))
                        .build(),
                Aggregation.group("lastName").count().as("count"),
                Aggregation.project(Fields.from(
                        Fields.field("lastName", "$_id"),
                        Fields.field("count"))),
                Aggregation.sort(Sort.Direction.DESC, "count"));
        return mongoOperations.aggregate(aggregation, "students", LastnameStatistic.class);
    }

    public @NotNull Flux<GenderStatistic> statisticGender() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("gender").count().as("count"),
                Aggregation.project(Fields.from(
                        Fields.field("gender", "$_id"),
                        Fields.field("count"))),
                Aggregation.sort(Sort.Direction.DESC, "count"));
        return mongoOperations.aggregate(aggregation, "students", GenderStatistic.class);
    }

    public @NotNull Flux<NationalityStatistic> statisticNationality() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("nationality").count().as("count"),
                Aggregation.project(Fields.from(
                        Fields.field("nationality", "$_id"),
                        Fields.field("count"))),
                Aggregation.sort(Sort.Direction.DESC, "count"));
        return mongoOperations.aggregate(aggregation, "students", NationalityStatistic.class);
    }
}
