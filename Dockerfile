FROM openjdk:21-jdk
WORKDIR /app
COPY . .
RUN chmod +x gradlew
RUN ./gradlew clean build -x test
RUN java -version  # Проверява Java версията
EXPOSE 8080
CMD ["java", "-jar", "build/libs/NaturalNatureFinalApp-0.0.1-SNAPSHOT.jar"]
# Force rebuild 2025-04-12