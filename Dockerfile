#FROM openjdk:21-jdk
#FROM eclipse-temurin:21-jdk-alpine
#WORKDIR /app
## Copy the JAR file
#COPY build/libs/app.jar app.jar
#
#RUN chmod +x gradlew
#RUN ./gradlew clean build -x test --stacktrace
#RUN java -version  # Проверява Java версията n
#EXPOSE 8080
#CMD ["java", "-jar", "build/libs/NaturalNatureFinalApp-0.0.1-SNAPSHOT.jar"]
#CMD ["java", "-Djavax.net.ssl.trustStore=/app/src/main/resources/certs/ca.pem", "-Djavax.net.ssl.trustStorePassword=changeit", "-jar", "build/libs/NaturalNatureFinalApp-0.0.1-SNAPSHOT.jar"]
# Force rebuild 2025-04-12
# Build stage
FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app
COPY gradle/ gradle/
COPY src/ src/
COPY build.gradle settings.gradle ./
COPY gradlew .
COPY gradlew.bat .
RUN chmod +x gradlew
RUN ./gradlew bootJar --no-daemon

# Run stage
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "app.jar"]
