# Establece la imagen base para compilar
FROM maven:3.8.4-openjdk-11 AS build

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo pom.xml para descargar las dependencias
COPY pom.xml .

# Descarga las dependencias (esto se almacenará en la capa de caché de Docker)
RUN mvn dependency:go-offline

# Copia el código fuente
COPY src ./src

# Compila el proyecto y empaqueta el JAR
RUN mvn package -DskipTests

# Etapa final: Ejecuta la aplicación Spring Boot
FROM openjdk:11-jdk-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR compilado de la etapa anterior
COPY --from=build /app/target/rickmorty.jar .

# Expone el puerto en el que la aplicación Spring Boot se ejecuta
EXPOSE 8082

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "rickmorty.jar"]
