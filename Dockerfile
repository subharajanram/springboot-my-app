FROM openjdk:8-jdk-alpine
MAINTAINER Subha Ram
COPY springboot-my-app-0.0.1-SNAPSHOT.jar springboot-my-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/springboot-my-app-0.0.1-SNAPSHOT.jar"]