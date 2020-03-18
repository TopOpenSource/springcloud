FROM openjdk:8-jdk-alpine
MAINTAINER cheng/chengang@sdas.org
RUN mkdir -p /root/log
ADD eureka.jar /root/eureka.jar
ENV server_port variable
ENTRYPOINT exec java -jar /root/eureka.jar --server.port=$server_port