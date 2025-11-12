package co.com.scheduler.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> route(OutfitHandler handler) {
        return RouterFunctions.route()
                .POST("/api/outfit", handler::listenPOSTUseCase)
                .GET("/api/outfit/{id}", handler::listenGETUseCase)
                .GET("/api/outfit", handler::listenGETOtherUseCase)
                .DELETE("/api/outfit/delete/{id}", handler::deleteOutfit)
                .build();
    }
}
