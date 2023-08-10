# Utiliza una imagen base con Java 8
FROM openjdk:8-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copia el archivo JAR de la aplicación al contenedor
COPY spring-elasticsearch-client-0.0.1-SNAPSHOT.jar /app

# Ejecuta la aplicación Java
CMD ["java", "-jar", "spring-elasticsearch-client-0.0.1-SNAPSHOT.jar"]
