FROM openjdk:8-jdk-alpine
MAINTAINER cheng/chengang@sdas.org
#set env
ENV eureka_server variable
ENV server_port variable

RUN mkdir -p /root/log
ADD gateway.jar /root/gateway.jar

ENTRYPOINT exec java -jar /root/gateway.jar --server.port=$server_port --eureka-server=$eureka_server