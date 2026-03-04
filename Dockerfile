FROM openjdk:21-jdk-slim
WORKDIR /app

# This finds any JAR file anywhere in your project and
# renames it to 'app.jar' inside the container
COPY **/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]