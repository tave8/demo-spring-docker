# Stage 1: Build the image for the server
FROM eclipse-temurin:25-jdk-alpine
COPY target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]



