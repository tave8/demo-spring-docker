# Containerize a simple Java app with Docker

## Have Docker Desktop installed

Follow these steps in order.

## Pull JRE (Java Runtime Environment) Docker image

`docker pull eclipse-temurin:25-jre`

## Build JAR

`./mvnw clean package -DskipTests`

## Find output JAR

In `target` directory, find the JAR, something like `demo-spring-docker-0.0.1-SNAPSHOT.jar`

## Create Dockerfile

Replace `my_jar` with something like `target/demo-spring-docker-0.0.1-SNAPSHOT.jar`

Something like 
```
FROM eclipse-temurin:25-jre
COPY <my_jar> app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## Build Docker image from Dockerfile

Make sure you are in root directory.

Replace `<my_image>` with the project name. This will the image name.

`docker build --tag <my_image> .`

Verify that the image has been built: `docker images`

## Run container from image

Run the container in the background, give it a name.

The container name can be anything. The image name must match the image name of the previous step.

Host port is an available port on your machine, for example 8080.

Container port corresponds to the Java app (default 8080).

`docker run -d --name <my_container> -p <host_port>:<container_port> <my_image>`

Verify that the container is running with the correct port mapping: `docker ps`


