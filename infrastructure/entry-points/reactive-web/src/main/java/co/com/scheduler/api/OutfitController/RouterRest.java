package co.com.scheduler.api.OutfitController;

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
                .POST("/api/outfit/create", handler::createOutfit)
                .GET("/api/outfit/getOutfitById/{id}", handler::getOutfitById)
                .GET("/api/outfit/getAll", handler::getAllOutfits)
                .DELETE("/api/outfit/delete/{id}", handler::deleteOutfit)
                .build();
    }
}