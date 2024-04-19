FROM openjdk:17-jdk-slim AS build

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR logger-service
COPY --from=build target/*.jar logger-service.jar
ENTRYPOINT ["java", "-jar", "logger-service.jar"]