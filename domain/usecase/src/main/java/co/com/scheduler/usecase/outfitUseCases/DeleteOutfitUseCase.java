package co.com.scheduler.usecase.outfitUseCases;

import co.com.scheduler.model.outfit.gateways.OutfitRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class DeleteOutfitUseCase {
    private final OutfitRepository outfitRepository;

    public DeleteOutfitUseCase(OutfitRepository outfitRepository) {
        this.outfitRepository = outfitRepository;
    }

    public Mono<Void> deleteOutfit(UUID id) {
        return outfitRepository.getOutfitById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No outfit found with id: " + id)))
                .then(outfitRepository.deleteOutfit(id));
    }


}
