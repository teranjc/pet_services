# Etapa 2: Ejecución
FROM openjdk:17-jdk-slim

# Configura el directorio de trabajo
WORKDIR /app

# Copia el archivo WAR desde la etapa de construcción
COPY --from=build /app/target/myapp.war ./app.war

# Expone el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.war"]
