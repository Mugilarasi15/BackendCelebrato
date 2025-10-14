# =========================
# Stage 1: Build the JAR
# =========================
FROM maven:3.9.1-eclipse-temurin-17 AS build

# Set working directory inside the container
WORKDIR /app

# Copy pom.xml first to cache dependencies
COPY pom.xml .

# Copy source code
COPY src ./src

# Build the project (skip tests for faster build)
RUN mvn clean package -DskipTests

# =========================
# Stage 2: Run the JAR
# =========================
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port (Render sets PORT env variable)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
