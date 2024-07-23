FROM maven:3.9.5 AS build

# Instala OpenJDK 17
RUN apt-get update && apt-get install -y openjdk-17-jdk

# Configura el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y el directorio src
COPY pom.xml .
COPY src ./src

# Descarga las dependencias y construye la aplicación
RUN mvn clean package -DskipTests

# Lista el contenido del directorio /app/target
RUN ls -l /app/target
