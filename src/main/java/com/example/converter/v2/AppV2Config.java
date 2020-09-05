package com.example.converter.v2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV2Config {

    @Bean
    public ConversionService conversionService() {

        return new ConversionServiceImpl();
    }
}
