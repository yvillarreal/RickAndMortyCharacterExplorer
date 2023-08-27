# Establece la imagen base
FROM openjdk:11-jdk-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR compilado a la imagen
COPY target/rickmorty-0.0.1-SNAPSHOT.jar .

# Expone el puerto en el que la aplicación Spring Boot se ejecuta
EXPOSE 8082

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "RickAndMortyApp.jar"]
