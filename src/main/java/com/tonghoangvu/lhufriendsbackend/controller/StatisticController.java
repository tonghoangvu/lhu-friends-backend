package com.tonghoangvu.lhufriendsbackend.controller;

import com.tonghoangvu.lhufriendsbackend.model.statistic.GenderStatistic;
import com.tonghoangvu.lhufriendsbackend.model.statistic.LastnameStatistic;
import com.tonghoangvu.lhufriendsbackend.model.statistic.NationalityStatistic;
import com.tonghoangvu.lhufriendsbackend.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class StatisticController {
    private final @NotNull StatisticService statisticService;

    @GetMapping("/last-name")
    public @NotNull Flux<LastnameStatistic> getLastnameStatistic() {
        return statisticService.getLastnameStatistic();
    }

    @GetMapping("/gender")
    public @NotNull Flux<GenderStatistic> getGenderStatistic() {
        return statisticService.getGenderStatistic();
    }

    @GetMapping("/nationality")
    public @NotNull Flux<NationalityStatistic> getNationalityStatistic() {
        return statisticService.getNationalityStatistic();
    }
}
