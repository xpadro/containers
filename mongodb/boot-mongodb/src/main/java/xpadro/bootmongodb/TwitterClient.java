package xpadro.bootmongodb;

import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.event.Event;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;

import java.util.Arrays;
import java.util.concurrent.BlockingDeque;

public class TwitterClient {
    private BlockingDeque<String> messageQueue;
    private BlockingDeque<Event> eventQueue;

    public void test() {
        Hosts hosebirdHosts =new HttpHosts(Constants.STREAM_HOST);
        StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
        endpoint.trackTerms(Arrays.asList("springframework"));

        Authentication auth = new OAuth1("consumerkey", "consumersecret", "token", "secret");

        ClientBuilder builder = new ClientBuilder()
                .name("Hosebir-Client-01")
                .hosts(hosebirdHosts)
                .authentication(auth)
                .endpoint(endpoint)
                .processor(new StringDelimitedProcessor(messageQueue))
                .eventMessageQueue(eventQueue);

        Client client = builder.build();
        client.connect();
    }
}
