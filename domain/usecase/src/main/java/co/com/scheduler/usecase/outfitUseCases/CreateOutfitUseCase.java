package co.com.scheduler.usecase.outfitUseCases;

import co.com.scheduler.model.outfit.model.Outfit;
import co.com.scheduler.model.outfit.gateways.OutfitRepository;
import reactor.core.publisher.Mono;

public class CreateOutfitUseCase {

    private final OutfitRepository outfitRepository;

    public CreateOutfitUseCase(OutfitRepository outfitRepository) {
        this.outfitRepository = outfitRepository;
    }

    public Mono<Outfit> CreateOutfit(Outfit outfit) {
        return validateOutfit(outfit)
                .flatMap(outfitRepository::addOutfit);
    }

    private Mono<Outfit> validateOutfit(Outfit outfit) {

        if (outfit.getName() == null || outfit.getName().isBlank()) {
            return Mono.error(new IllegalArgumentException("Outfit name is required."));
        }

        return Mono.just(outfit);
    }
}

