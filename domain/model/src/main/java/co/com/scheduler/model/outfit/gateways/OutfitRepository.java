package co.com.scheduler.model.outfit.gateways;

import co.com.scheduler.model.outfit.Outfit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface OutfitRepository {

    Mono<Outfit> addOutfit(Outfit outfit);
    Mono<Outfit> getOutfitById(UUID id);
    Flux<Outfit> getAllOutfits();
    Mono<Outfit> deleteOutfit(Outfit outfit);
}
