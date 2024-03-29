package me.dio.sdw24.application;


import me.dio.sdw24.domain.exception.ChampionNotFoundException;
import me.dio.sdw24.domain.model.Champions;
import me.dio.sdw24.ports.ChampionsRepository;

import java.util.List;


public record AskChampionUseCase(ChampionsRepository  repository) {

    public String askChampion(Long ChampionId, String question){

        Champions champions = repository.findOne(ChampionId)
                .orElseThrow(() -> new ChampionNotFoundException(ChampionId) );

        String championContext = champions.generateContextByQuestion(question);
        return championContext;
    }
}
