# Use the latest version of Ubuntu
FROM ubuntu:latest AS build

# Install necessary packages
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk

# Copy the Gradle wrapper and build configuration
COPY gradlew /app/gradlew
COPY gradle /app/gradle
COPY build.gradle /app/build.gradle
COPY settings.gradle /app/settings.gradle

# Set the working directory
WORKDIR /app

# Build the application
RUN ./gradlew bootJar --no-daemon

# Use a smaller base image for the final stage
FROM openjdk:21-jdk-slim

# Expose the application port
EXPOSE 8080

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/how-much-pay-api-0.0.1.jar app.jar

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
