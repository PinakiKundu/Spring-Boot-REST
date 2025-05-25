FROM openjdk:11-jre-slim
EXPOSE 8080

ARG APP_VERSION=1.0.0
ARG JAR_FILE=target/Spring-Boot-REST-${APP_VERSION}.jar
COPY ./${JAR_FILE} app.jar

CMD ["sh", "-c", "java -XX:+UseG1GC -jar app.jar"]
