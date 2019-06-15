Executes a Java Spring Boot web application with an endpoint returning a 'hello world' message

## Build the image
Execute the following command in the folder where the Dockerfile is located (root of the app):

```
$ ./mvnw install dockerfile:build
```


## Run the container
```
$ docker run -p 8080:8080 xpadro/hellow-world-java
```

## Use the web application
Once up and running, head to the browser and type the following URL. You should see a hello world message:
```
localhost:8080/hello
```
