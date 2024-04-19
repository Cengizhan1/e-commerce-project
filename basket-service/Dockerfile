FROM openjdk:17-jdk-slim AS build

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR basket-service
COPY --from=build target/*.jar basket-service.jar
ENTRYPOINT ["java", "-jar", "basket-service.jar"]