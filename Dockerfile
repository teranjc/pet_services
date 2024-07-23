# Usa una imagen base de Maven para construir el proyecto
FROM maven:3.9.5-openjdk-17 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y el directorio src al contenedor
COPY pom.xml .
COPY src ./src

# Construye el proyecto
RUN mvn clean package -DskipTests

# Usa una imagen base de OpenJDK para ejecutar el archivo WAR
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo WAR del contenedor de construcción
COPY --from=build /app/target/pet.war /app/pet.war

# Expone el puerto en el que la aplicación escucha
EXPOSE 8080

# Comando para ejecutar el archivo WAR
ENTRYPOINT ["java", "-jar", "/app/pet.war"]
