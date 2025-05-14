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
# Build stage
FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

# Copy gradle configuration first
COPY gradle gradle
COPY gradlew .
COPY gradlew.bat .
COPY build.gradle .
COPY settings.gradle .

# Make gradlew executable
RUN chmod +x gradlew

# Download dependencies
RUN ./gradlew dependencies --no-daemon

# Copy source code
COPY src src

# Build the application
RUN ./gradlew bootJar --no-daemon

# Run stage
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy the jar file from the build stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Environment variables
ENV PORT=8000
ENV SPRING_PROFILES_ACTIVE=prod

# Expose the port
EXPOSE ${PORT}

# Set the startup command
ENTRYPOINT ["java", \
            "-XX:+UseContainerSupport", \
            "-XX:MaxRAMPercentage=75.0", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-jar", \
            "app.jar"]
CMD ["java", "-jar", "app.jar"]
