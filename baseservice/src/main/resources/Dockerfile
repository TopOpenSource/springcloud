FROM openjdk:8-jdk-alpine
MAINTAINER cheng/chengang@sdas.org
#set env
ENV config_url variable
ENV config_name variable
ENV config_profile variable

RUN mkdir -p /root/log
ADD baseservice.jar /root/baseservice.jar

ENTRYPOINT exec java -jar /root/baseservice.jar --spring.cloud.config.uri=$config_url --spring.cloud.config.name=$config_name --spring.cloud.config.profile=$config_profile