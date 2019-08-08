package xpadro.bootmongodb.twitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import xpadro.bootmongodb.repository.MessageRepository;
import xpadro.bootmongodb.model.Tweet;

import java.text.SimpleDateFormat;

@Service
public class TwitterListener implements StatusListener {
    private final Logger logger = LoggerFactory.getLogger(TwitterListener.class);
    private final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private final MessageRepository repository;

    public TwitterListener(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onStatus(Status status) {
        logger.info(status.getUser().getScreenName() + " | " + status.getText() + " | " + format.format(status.getCreatedAt()));

        repository
                .insert(Mono.just(new Tweet(status.getId(), status.getUser().getScreenName(), status.getText())))
                .subscribe();
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

    }

    @Override
    public void onScrubGeo(long userId, long upToStatusId) {

    }

    @Override
    public void onStallWarning(StallWarning warning) {

    }

    @Override
    public void onException(Exception ex) {

    }
}
