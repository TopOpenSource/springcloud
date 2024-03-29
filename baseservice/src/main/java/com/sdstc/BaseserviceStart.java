package com.sdstc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 
 * @author cheng
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableEurekaClient
@MapperScan("com.sdstc.*.dao")
@EnableAsync  //允许异步请求
public class BaseserviceStart{
	public static void main(String[] args) {
        SpringApplication.run(BaseserviceStart.class, args);
    }
}