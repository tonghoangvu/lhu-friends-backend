package com.tonghoangvu.lhufriendsbackend.service;

import com.tonghoangvu.lhufriendsbackend.model.statistic.LastnameStatistic;
import com.tonghoangvu.lhufriendsbackend.repository.CustomStatisticRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class StatisticService {
    private final @NotNull CustomStatisticRepository customStatisticRepository;

    public Flux<LastnameStatistic> getLastnameStatistic() {
        return customStatisticRepository.statisticLastname();
    }
}
