FROM openjdk:17-jdk-slim AS build

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR wallet-service
COPY --from=build target/*.jar wallet-service.jar
ENTRYPOINT ["java", "-jar", "wallet-service.jar"]