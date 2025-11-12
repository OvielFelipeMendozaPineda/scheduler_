package co.com.scheduler.r2dbc;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import java.util.UUID;

// TODO: This file is just an example, you should delete or modify it
public interface MyReactiveRepository extends ReactiveCrudRepository
        <Outfit, UUID>, ReactiveQueryByExampleExecutor<Outfit> {

}
