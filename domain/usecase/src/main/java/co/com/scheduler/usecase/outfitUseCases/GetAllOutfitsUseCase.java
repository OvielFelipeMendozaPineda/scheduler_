package co.com.scheduler.usecase.outfitUseCases;

import co.com.scheduler.model.outfit.gateways.OutfitRepository;
import co.com.scheduler.model.outfit.model.Outfit;
import reactor.core.publisher.Flux;

public class GetAllOutfitsUseCase {

    private final OutfitRepository outfitRepository;

    public GetAllOutfitsUseCase(OutfitRepository outfitRepository) {
        this.outfitRepository = outfitRepository;
    }

    public Flux<Outfit> getAllOutfits() {
        return outfitRepository.getAllOutfits()
                .switchIfEmpty(Flux.error(new RuntimeException("No outfits were found.")));
    }
}
