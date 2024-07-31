# Stage 1: Builder
FROM maven:3.9.2-eclipse-temurin-17-alpine as builder

COPY ./src src/
COPY ./pom.xml pom.xml

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-alpine

COPY --from=builder target/*.jar backend.jar
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "backend.jar"]