package xpadro.bootmongodb.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import xpadro.bootmongodb.model.Tweet;

@Repository
public interface MessageRepository extends ReactiveMongoRepository<Tweet, Long> {
}
