package com.tonghoangvu.lhufriendsbackend.controller;

import com.tonghoangvu.lhufriendsbackend.model.statistic.*;
import com.tonghoangvu.lhufriendsbackend.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class StatisticController {
    private final @NotNull StatisticService statisticService;

    @GetMapping("/last-name")
    @CrossOrigin(origins = "*")
    public @NotNull Flux<LastnameStatistic> getLastnameStatistic() {
        return statisticService.getLastnameStatistic();
    }

    @GetMapping("/gender")
    @CrossOrigin(origins = "*")
    public @NotNull Flux<GenderStatistic> getGenderStatistic() {
        return statisticService.getGenderStatistic();
    }

    @GetMapping("/nationality")
    @CrossOrigin(origins = "*")
    public @NotNull Flux<NationalityStatistic> getNationalityStatistic() {
        return statisticService.getNationalityStatistic();
    }

    @GetMapping("/ethnic")
    @CrossOrigin(origins = "*")
    public @NotNull Flux<EthinicStatistic> getEthnicStatistic() {
        return statisticService.getEthnicStatistic();
    }

    @GetMapping("/place-of-birth")
    @CrossOrigin(origins = "*")
    public @NotNull Flux<PlaceOfBirthStatistic> getPlaceOfBirthStatistic() {
        return statisticService.getPlaceOfBirthStatistic();
    }

    @GetMapping("/day-of-birth")
    @CrossOrigin(origins = "*")
    public @NotNull Flux<DayOfBirthStatistic> getDayOfBirthStatistic() {
        return statisticService.getDayOfBirthStatistic();
    }

    @GetMapping("/month-of-birth")
    @CrossOrigin(origins = "*")
    public @NotNull Flux<MonthOfBirthStatistic> getMonthOfBirthStatistic() {
        return statisticService.getMonthOfBirthStatistic();
    }
}
