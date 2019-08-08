package xpadro.bootmongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.CollectionUtils;
import xpadro.bootmongodb.model.Tweet;
import xpadro.bootmongodb.twitter.TwitterApiClient;

import java.util.List;

@SpringBootApplication
public class BootMongodbApplication {
	private static final Logger logger = LoggerFactory.getLogger(BootMongodbApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootMongodbApplication.class, args);

		retrieveStoredTweets();
		callTwitterApiClient(context);
	}

	private static void retrieveStoredTweets() {
		logger.info("Retrieving stored tweets...");

		TwitterWebClient client = new TwitterWebClient();
		List<Tweet> tweets = client.getTweets().collectList().block();

		if (!CollectionUtils.isEmpty(tweets)) {
			tweets.forEach(m -> logger.info(m.toString()));
		}

	}

	private static void callTwitterApiClient(ConfigurableApplicationContext context) {
		logger.info("Start streaming new tweets...");

		context.getBean(TwitterApiClient.class).stream();
	}

}
