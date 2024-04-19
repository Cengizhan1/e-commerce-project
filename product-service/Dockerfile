FROM openjdk:17-jdk-slim AS build

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR product-service
COPY --from=build target/*.jar product-service.jar
ENTRYPOINT ["java", "-jar", "product-service.jar"]