# Etapa 1: Construcción
FROM maven:3.9.2-eclipse-temurin-17 AS build

# Configura el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y el directorio src
COPY pom.xml .
COPY src ./src

# Descarga las dependencias y construye la aplicación
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución
FROM openjdk:17-jdk-slim

# Configura el directorio de trabajo
WORKDIR /app

# Copia el archivo WAR desde la etapa de construcción
COPY --from=build /app/target/pet-0.0.1-SNAPSHOT.war ./app.war

# Expone el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.war"]
