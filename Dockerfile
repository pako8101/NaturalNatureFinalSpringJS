FROM openjdk:21-jdk
WORKDIR /app
COPY . .
RUN chmod +x gradlew
RUN ./gradlew clean build -x test --stacktrace
RUN java -version  # Проверява Java версията n
EXPOSE 8080
#CMD ["java", "-jar", "build/libs/NaturalNatureFinalApp-0.0.1-SNAPSHOT.jar"]
CMD ["java", "-Djavax.net.ssl.trustStore=/app/src/main/resources/certs/ca.pem", "-Djavax.net.ssl.trustStorePassword=changeit", "-jar", "build/libs/NaturalNatureFinalApp-0.0.1-SNAPSHOT.jar"]
# Force rebuild 2025-04-12
FROM eclipse-temurin:21-jdk-alpine
