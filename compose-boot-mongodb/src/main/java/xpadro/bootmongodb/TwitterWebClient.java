package xpadro.bootmongodb;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import xpadro.bootmongodb.model.Tweet;

class TwitterWebClient {
    private WebClient client = WebClient.create("http://localhost:8080");

    Flux<Tweet> getTweets() {
        return client.get()
                .uri("/tweets")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Tweet.class);
    }
}
