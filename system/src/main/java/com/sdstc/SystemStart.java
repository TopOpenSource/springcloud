package com.sdstc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.sdstc.*.dao")
public class SystemStart{
	public static void main(String[] args) {
        SpringApplication.run(SystemStart.class, args);
    }
}
