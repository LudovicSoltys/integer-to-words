package com.example.converter.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppV2ExposedConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppV2ExposedConfig.class, args);
    }

    @Bean
    public ExtraLongNumberRestService service(@Autowired ConversionService conversionService) {

        return new ExtraLongNumberRestService(conversionService);

    }
}
