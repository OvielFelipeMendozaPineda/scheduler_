package co.com.scheduler.api.OutfitReactiveController;

import co.com.scheduler.model.outfit.model.Outfit;
import co.com.scheduler.usecase.outfitUseCases.CreateOutfitUseCase;
import co.com.scheduler.usecase.outfitUseCases.DeleteOutfitUseCase;
import co.com.scheduler.usecase.outfitUseCases.GetAllOutfitsUseCase;
import co.com.scheduler.usecase.outfitUseCases.GetOutfitByIDUseCase;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class OutfitHandler {

    private  final CreateOutfitUseCase createOutfitUseCase;
    private final DeleteOutfitUseCase deleteOutfitUseCase;
    private final GetAllOutfitsUseCase getAllOutfitsUseCase;
    private final GetOutfitByIDUseCase getOutfitByIDUseCase;

    public OutfitHandler(
            CreateOutfitUseCase createOutfitUseCase,
            DeleteOutfitUseCase deleteOutfitUseCase,
            GetAllOutfitsUseCase getAllOutfitsUseCase,
            GetOutfitByIDUseCase getOutfitByIDUseCase) {

        this.createOutfitUseCase = createOutfitUseCase;
        this.deleteOutfitUseCase = deleteOutfitUseCase;
        this.getAllOutfitsUseCase = getAllOutfitsUseCase;
        this.getOutfitByIDUseCase = getOutfitByIDUseCase;
    }

    public Mono<ServerResponse> getOutfitById(ServerRequest serverRequest) {
        UUID id = UUID.fromString(serverRequest.pathVariable("id"));
        return ServerResponse.ok()
                .body(getOutfitByIDUseCase.getOutfitById(id), Outfit.class)
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));

    }

    public Mono<ServerResponse> createOutfit(ServerRequest serverRequest) {

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

    public Mono<ServerResponse> getAllOutfits(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(getAllOutfitsUseCase.getAllOutfits(), Outfit.class)
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }
}
