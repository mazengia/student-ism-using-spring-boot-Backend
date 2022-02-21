
FROM openjdk:13-alpine
MAINTAINER Mazengia Tesfa <mtesfa@gmail.com>
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ENV SPRING_PROFILES_ACTIVE=live
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN mkdir -p /home/spring/uploads
RUN mkdir /home/spring/logs

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]