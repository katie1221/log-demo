package com.example.logdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author qzz
 */
@SpringBootApplication
@MapperScan("com.example.logdemo.dao")
public class LogDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogDemoApplication.class, args);
    }

}
