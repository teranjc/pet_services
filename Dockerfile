# Use the latest version of Ubuntu
FROM ubuntu:latest AS build

# Install necessary packages
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

# Copy the Maven configuration and application source code
COPY pom.xml /app/pom.xml
COPY src /app/src

# Set the working directory
WORKDIR /app

# Use a smaller base image for the final stage
FROM openjdk:21-jdk-slim

# Expose the application port
EXPOSE 8080

# Copy the JAR file from the build stage
COPY --from=build /app/target/how-much-pay-api-0.0.1.jar app.jar

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
