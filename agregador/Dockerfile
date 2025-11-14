# Usa una imagen base ligera de Java 17
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el .jar (construido por Maven) al contenedor
# El *.jar significa que tomará el .jar que encuentre
COPY target/*.jar app.jar

# Expone el puerto que definiste en application.properties
EXPOSE 8080

# Comando para correr la aplicación
ENTRYPOINT ["java","-jar","/app.jar"]