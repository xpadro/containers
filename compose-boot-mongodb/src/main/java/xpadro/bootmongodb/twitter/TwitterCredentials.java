package xpadro.bootmongodb.twitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwitterCredentials {

    @Value("${oauth.consumer.key:false}")
    private String consumerKey;

    @Value("${oauth.consumer.secret:false}")
    private String consumerSecret;

    @Value("${oauth.access.token:false}")
    private String accessToken;

    @Value("${oauth.access.token.secret:false}")
    private String accessTokenSecret;


    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }
}
