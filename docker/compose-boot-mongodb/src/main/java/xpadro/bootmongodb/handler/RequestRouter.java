package xpadro.bootmongodb.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RequestRouter {

    @Bean
    public RouterFunction<ServerResponse> route(RequestHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/tweets")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::handle);
    }
}
