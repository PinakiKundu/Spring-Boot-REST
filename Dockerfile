FROM openjdk:11-jre-slim
EXPOSE 8080

ARG APP_VERSION=0.0.1-SNAPSHOT
ARG JAR_FILE=build/libs/Spring-Boot-REST-${APP_VERSION}.jar
COPY ./${JAR_FILE} app.jar

CMD ["sh", "-c", "java -XX:+UseG1GC -jar app.jar"]
