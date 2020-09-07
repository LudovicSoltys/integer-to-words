package com.example.converter.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class AppV2WebConfig {

    @Bean
    public ExtraLongConversionService extraLongConversionService() {
        return new ExtraLongExtraLongConversionServiceImpl();
    }

    @Bean
    public ExtraLongNumberRestService extraLongNumberRestService(@Autowired ExtraLongConversionService service) {
        return new ExtraLongNumberRestService(service);
    }
}
