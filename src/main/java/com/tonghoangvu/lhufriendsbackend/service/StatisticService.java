package com.tonghoangvu.lhufriendsbackend.service;

import com.tonghoangvu.lhufriendsbackend.model.statistic.*;
import com.tonghoangvu.lhufriendsbackend.repository.CustomStatisticRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class StatisticService {
    private final @NotNull CustomStatisticRepository customStatisticRepository;

    public @NotNull Flux<LastnameStatistic> getLastnameStatistic() {
        return customStatisticRepository.statisticLastname();
    }

    public @NotNull Flux<GenderStatistic> getGenderStatistic() {
        return customStatisticRepository.statisticGender();
    }

    public @NotNull Flux<NationalityStatistic> getNationalityStatistic() {
        return customStatisticRepository.statisticNationality();
    }

    public @NotNull Flux<EthinicStatistic> getEthnicStatistic() {
        return customStatisticRepository.statisticEthnic();
    }

    public @NotNull Flux<PlaceOfBirthStatistic> getPlaceOfBirthStatistic() {
        return customStatisticRepository.statisticPlaceOfBirth();
    }
}
