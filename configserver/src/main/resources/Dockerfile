FROM openjdk:8-jdk-alpine
MAINTAINER cheng/chengang@sdas.org
#set env
ENV rabbitmq_host=""
ENV rabbitmq_port=""
ENV rabbitmq_username=""
ENV rabbitmq_password=""
ENV eureka-server=""
ENV server-port=""

RUN mkdir -p /root/log
RUN mkdir -p /root/config
ADD configserver.jar /root/configserver.jar
COPY config  /root/config 

ENTRYPOINT ["sh","-c","java -jar /root/configserver.jar --spring.rabbitmq.host=$rabbitmq_host --spring.rabbitmq.port=$rabbitmq_port --spring.rabbitmq.username=$rabbitmq_username --spring.rabbitmq.password=$rabbitmq_password --eureka-server=$eureka-server --server.port=$server-port"]
