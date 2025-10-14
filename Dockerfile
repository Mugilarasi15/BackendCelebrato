# Use OpenJDK 17 slim image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built jar
COPY target/*.jar app.jar

# Expose port (Render sets PORT env var)
ENV PORT=8080
EXPOSE $PORT

# Run the Spring Boot app
ENTRYPOINT ["java","-jar","app.jar"]
