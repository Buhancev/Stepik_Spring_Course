FROM openjdk:19-jdk-alpine
MAINTAINER Maxim Buhancev
COPY target/spring_cource_rest.war rest.war
ENTRYPOINT ["java","-jar","/rest.war"]
