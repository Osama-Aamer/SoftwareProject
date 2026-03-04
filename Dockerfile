FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Change this line - the '.' at the end is the secret!
COPY **/target/*.jar ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]