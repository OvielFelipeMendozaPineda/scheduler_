package co.com.scheduler.usecase.outfitUseCases;

import co.com.scheduler.model.outfit.gateways.OutfitRepository;
import co.com.scheduler.model.outfit.model.Outfit;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class GetOutfitByIDUseCase {

    private final OutfitRepository outfitRepository;

    public GetOutfitByIDUseCase(OutfitRepository outfitRepository) {
        this.outfitRepository = outfitRepository;
    }

    public Mono<Outfit> getOutfitById(UUID id) {
        return  outfitRepository.getOutfitById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No outfit found with such id: " + id)));
    }
}
