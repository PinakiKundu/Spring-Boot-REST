# ===== Stage 1: Build the application =====
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /build

# Copy only the build files first to leverage Docker cache
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# ===== Stage 2: Run the application =====
FROM eclipse-temurin:17-jre-jammy

# Create a non-root user
RUN useradd -m appuser

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=builder /build/target/*.jar app.jar
RUN chown appuser:appuser app.jar

# Switch to non-root user
USER appuser

# Expose the application port
EXPOSE 8080

# Use exec form for better signal handling
ENTRYPOINT ["java", "-XX:+UseG1GC", "-jar", "app.jar"]
