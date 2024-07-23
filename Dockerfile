# Etapa 1: Construcción
FROM maven:3.9.2-eclipse-temurin-17 AS build
RUN apt-get update && apt-get install -y openjdk-17-jdk
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/pet-0.0.1-SNAPSHOT.war ./app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.war"]