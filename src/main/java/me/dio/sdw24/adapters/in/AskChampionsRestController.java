package me.dio.sdw24.adapters.in;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.sdw24.application.AskChampionUseCase;
import me.dio.sdw24.application.ListChampionsUseCase;
import me.dio.sdw24.domain.model.Champions;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Campeões", description = "Endpoints do dominio de campeões do LoL")
@RestController
@RequestMapping("/champions")
public record AskChampionsRestController(AskChampionUseCase useCase) {

    @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampion(@PathVariable Long championId, @RequestBody AskChampionRequest request) {

        String answer = useCase.askChampion(championId, request.question());

        return new AskChampionResponse(answer);
    }

    public record AskChampionRequest(String question){ }
    public record AskChampionResponse(String answer){ }
}
