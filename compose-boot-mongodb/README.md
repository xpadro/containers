Docker compose example with the following services:

* Spring Boot webflux application which retrieves tweets from the Twitter API
* MongoDB database

## PREPARATION
In order to be able to use the Twitter API you have to do the following:

1. Create an account at [Twitter developers site](https://developer.twitter.com)
2. Create a file called 'environment' in the root of the project. Here you should store your credentials in the following form:
   * oauth.consumer.key=XXX
   * oauth.consumer.secret=YYY
   * oauth.access.token=ZZZ
   * oauth.access.token.secret=WWW

## Build the image
From the command line at the root of the project, execute:
```
./mvnw clean install
```

Then, execute:
```
docker-compose build
```

## Run the containers
```
docker-compose up
```

## Execution
Once you run the containers, the application will retrieve the previously stored tweets from MongoDB (if it is not the first time you run the app since we are using named volumes) and then call the Twitter streaming API to start getting new tweets from Twitter.

Additionally, you can open the browser and retrieve the list of stored tweets by typing:
```
localhost:8080/tweets
```
