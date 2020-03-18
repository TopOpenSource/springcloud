FROM openjdk:8-jdk-alpine
MAINTAINER cheng/chengang@sdas.org
#set env
ENV rabbitmq_host variable
ENV rabbitmq_port variable
ENV rabbitmq_username variable
ENV rabbitmq_password variable
ENV eureka_server variable
ENV server_port variable

RUN mkdir -p /root/log
RUN mkdir -p /root/config
ADD configserver.jar /root/configserver.jar

ENTRYPOINT exec java -jar /root/configserver.jar --spring.rabbitmq.host=$rabbitmq_host --spring.rabbitmq.port=$rabbitmq_port --spring.rabbitmq.username=$rabbitmq_username --spring.rabbitmq.password=$rabbitmq_password --eureka-server=$eureka_server --server.port=$server_port