package com.example.converter.v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class AppV2WebConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppV2WebConfig.class, args);
    }
}
