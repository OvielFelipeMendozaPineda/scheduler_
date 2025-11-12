package co.com.scheduler.r2dbc.OutfitPersistence;

import co.com.scheduler.model.outfit.gateways.OutfitRepository;
import co.com.scheduler.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public class OutfitReactiveRepositoryAdapter extends ReactiveAdapterOperations<co.com.scheduler.model.outfit.model.Outfit, Outfit, UUID, OutfitReactiveRepository> implements OutfitRepository {

    public OutfitReactiveRepositoryAdapter(OutfitReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, co.com.scheduler.model.outfit.model.Outfit.class));
    }

    @Override
    public Mono<co.com.scheduler.model.outfit.model.Outfit> addOutfit(co.com.scheduler.model.outfit.model.Outfit outfit) {
        return repository.save(toData(outfit))
                .map(entity -> mapper.map(entity, co.com.scheduler.model.outfit.model.Outfit.class));
    }

    @Override
    public Mono<co.com.scheduler.model.outfit.model.Outfit> getOutfitById(UUID id) {
        return repository.findById(id)
                .map(entity -> mapper.map(entity, co.com.scheduler.model.outfit.model.Outfit.class));
    }

    @Override
    public Flux<co.com.scheduler.model.outfit.model.Outfit> getAllOutfits() {
        return repository.findAll()
                .map(entity -> mapper.map(entity, co.com.scheduler.model.outfit.model.Outfit.class));
    }

    @Override
    public Mono<Void> deleteOutfit(UUID id) {
        return repository.deleteById(id);
    }
}
