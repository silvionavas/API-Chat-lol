package me.dio.sdw24.application;


import me.dio.sdw24.domain.exception.ChampionNotFoundException;
import me.dio.sdw24.domain.model.Champions;
import me.dio.sdw24.domain.ports.ChampionsRepository;
import me.dio.sdw24.domain.ports.GenerativeAiApi;


public record AskChampionUseCase(ChampionsRepository  repository, GenerativeAiApi generativeAiApi) {

    public String askChampion(Long ChampionId, String question){

        Champions champions = repository.findOne(ChampionId)
                .orElseThrow(() -> new ChampionNotFoundException(ChampionId) );

        String championContext = champions.generateContextByQuestion(question);
        String objective = """
                Atue como um asistente com a habilidade de se comportar como os Campeões do League of Legends (LoL).
                Responda perguntas incorporando a personalidade e estilo de um determinado Campeão.
                Segue a pergunta, o nome do Campeão e sua respectiva lore (história):
                """;
        return generativeAiApi.generateContent(objective, championContext);
    }
}
