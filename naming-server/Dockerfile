FROM openjdk:17-jdk-slim AS build

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR naming-server
COPY --from=build target/*.jar naming-server.jar
ENTRYPOINT ["java", "-jar", "naming-server.jar"]