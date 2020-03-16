FROM openjdk:8-jdk-alpine
MAINTAINER cheng/chengang@sdas.org
RUN mkdir -p /root/log
ADD eureka.jar /root/eureka.jar
ENTRYPOINT ["nohup","java","-jar","/root/eureka.jar","&"]

