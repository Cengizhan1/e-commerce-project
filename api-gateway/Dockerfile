FROM openjdk:17-jdk-slim AS build

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR api-gateway
COPY --from=build target/*.jar api-gateway.jar
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]