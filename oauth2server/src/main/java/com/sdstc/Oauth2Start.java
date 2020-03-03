package com.sdstc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sdstc.dao")
public class Oauth2Start {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2Start.class, args);
    }
}
