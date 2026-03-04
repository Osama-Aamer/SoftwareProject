FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Use the direct path to find the JAR and name it app.jar in the current folder
COPY Software-Project1/Junit-testing-temperature/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]