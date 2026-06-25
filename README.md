# Containerize a simple Java app with Docker


## Have Docker Desktop installed

Follow these steps in order.

## Pull JRE (Java Runtime Environment) Docker image


Runtime only: 

`docker pull eclipse-temurin:25-jre-alpine`

JDK:

`docker pull eclipse-temurin:25-jdk-alpine`

## Build JAR

In pom.xml, specify how the JAR file will be called:

Add the XML tag `<finalName>`. This examples means "the output JAR file will be called `app.jar`".


```
<build>
    <!-- here -->
    <finalName>app</finalName>
    <plugins>
       ...
    </plugins>
</build>
```

Then, at the root directory, run:

`./mvnw clean package -DskipTests`

Maven will build the project into a JAR.

Note: the JAR is not built automatically. 

## Find output JAR

Because we've specified the jar output file, we already know how it's called.

## Create Dockerfile

Replace `my_jar` with something like `target/app.jar`. 

This is the filepath of the output jar.

Something like 
```
FROM eclipse-temurin:25-jre-alpine
COPY <my_jar> app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## Build Docker image from Dockerfile

Make sure you are in root directory.

Replace `<my_image>` with the project name (This name does not exist yet, you choose it). 

This will build the Dockerfile in the current directory (root) into an image with the name you choose.

`docker build --tag <my_image> .`

Verify that the image has been built: `docker images`

## Run container from image

Run the container in the background, give it a name.

The container name can be anything. The image name must match the image name of the previous step.

Host port is an available port on your machine, for example 8080.

Container port corresponds to the Java app (default 8080).

`docker run -d --name <my_container> -p <host_port>:<container_port> <my_image>`

Verify that the container is running with the correct port mapping: `docker ps`




## Build many containers

You must use the `--build` flag. If you don't, Docker will use the cached code.

`docker compose up --build`


`
./mvnw clean package -DskipTests
docker compose up --build
`

