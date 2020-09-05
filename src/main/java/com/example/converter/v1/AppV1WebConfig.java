package com.example.converter.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class AppV1WebConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppV1WebConfig.class, args);
    }
}
