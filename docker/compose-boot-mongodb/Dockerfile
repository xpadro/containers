FROM openjdk:8-jdk

VOLUME /tmp

COPY ./target/boot-mongodb-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]