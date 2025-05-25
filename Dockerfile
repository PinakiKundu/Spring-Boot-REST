# Use a minimal, non-root base image
FROM eclipse-temurin:11-jre-jammy

# Create non-root user
RUN useradd -m appuser

# Set working directory
WORKDIR /app

# Use ARGs during build
ARG APP_VERSION=1.0.0
ARG JAR_FILE=target/Spring-Boot-REST-${APP_VERSION}.jar

# Copy jar to working directory
COPY --chown=appuser:appuser ${JAR_FILE} app.jar

# Switch to non-root user
USER appuser

# Expose only required port
EXPOSE 8080

# Use exec form and specify full path for better reliability
ENTRYPOINT ["java", "-XX:+UseG1GC", "-jar", "app.jar"]

