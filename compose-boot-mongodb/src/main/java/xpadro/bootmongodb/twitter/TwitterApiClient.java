package xpadro.bootmongodb.twitter;

import org.springframework.stereotype.Service;
import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

@Service
public class TwitterApiClient {
    private final TwitterStreamFactory factory;
    private final FilterQuery query;
    private final TwitterListener listener;


    public TwitterApiClient(TwitterListener listener, TwitterCredentials credentials) {
        this.listener = listener;

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setDebugEnabled(true);
        builder.setOAuthConsumerKey(credentials.getConsumerKey());
        builder.setOAuthConsumerSecret(credentials.getConsumerSecret());
        builder.setOAuthAccessToken(credentials.getAccessToken());
        builder.setOAuthAccessTokenSecret(credentials.getAccessTokenSecret());

        query = new FilterQuery();
        query.track(new String[]{"springframework", "java", "python"});
        query.language(new String[]{"en"});

        factory = new TwitterStreamFactory(builder.build());
    }

    public void stream() {
        TwitterStream twitterStream = factory.getInstance();
        twitterStream.addListener(listener);
        twitterStream.filter(query);
    }
}
