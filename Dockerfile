# Use the stable, modern Temurin image
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Your wildcard copy remains the same
COPY **/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]