package co.com.scheduler.api;

import co.com.scheduler.model.outfit.model.Outfit;
import co.com.scheduler.usecase.outfitUseCases.CreateOutfitUseCase;
import co.com.scheduler.usecase.outfitUseCases.DeleteOutfitUseCase;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class OutfitHandler {

    private  final CreateOutfitUseCase createOutfitUseCase;
    private final DeleteOutfitUseCase deleteOutfitUseCase;

    public OutfitHandler(
            CreateOutfitUseCase createOutfitUseCase,
            DeleteOutfitUseCase deleteOutfitUseCase) {

        this.createOutfitUseCase = createOutfitUseCase;
        this.deleteOutfitUseCase = deleteOutfitUseCase;
    }

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(Outfit.class)
                .flatMap(createOutfitUseCase::CreateOutfit)
                .flatMap(outfit -> ServerResponse.ok().bodyValue(outfit))
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> deleteOutfit(ServerRequest serverRequest) {
        UUID id = UUID.fromString(serverRequest.pathVariable("id"));
        return deleteOutfitUseCase.deleteOutfit(id)
                .then(ServerResponse.noContent().build())
                .onErrorResume(error ->
                        ServerResponse.badRequest().bodyValue(error.getMessage()));
    }
}
