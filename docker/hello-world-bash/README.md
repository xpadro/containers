Prints a hello world message on the console, using an environment variable to print a name.

## Build the image
Execute the following command in the folder where the Dockerfile is located:

```
$ docker build -t img-hello .
```


## Run the container
```
$ docker run --rm --name cont-hello img-hello
```
