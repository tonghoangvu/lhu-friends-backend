package com.tonghoangvu.lhufriendsbackend.controller;

import com.tonghoangvu.lhufriendsbackend.model.statistic.LastnameStatistic;
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
    public Flux<LastnameStatistic> getLastnameStatistic() {
        return statisticService.getLastnameStatistic();
    }
}
