package xpadro.bootmongodb.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import xpadro.bootmongodb.model.Tweet;
import xpadro.bootmongodb.repository.MessageRepository;

@Component
public class RequestHandler {
    private final MessageRepository repository;

    public RequestHandler(MessageRepository repository) {
        this.repository = repository;
    }


    Mono<ServerResponse> handle(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(repository.findAll(), Tweet.class);
    }
}
