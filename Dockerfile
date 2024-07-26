# Usar una imagen base de Java 17
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado al contenedor
COPY target/techrevamp-0.0.1-SNAPSHOT.jar /app/techrevamp-0.0.1-SNAPSHOT.jar

# Exponer el puerto en el que tu aplicación Spring Boot se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "techrevamp-0.0.1-SNAPSHOT.jar"]
