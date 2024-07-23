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
FROM openjdk:17-jdk-slim

# Expose the application port
EXPOSE 8080

# Copia el archivo WAR desde la etapa de construcción
COPY --from=build /app/target/pet-0.0.1-SNAPSHOT.war ./app.war

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.war"]