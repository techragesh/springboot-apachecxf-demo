package com.techjava.springbootapachecxfdemo.config;

import com.techjava.springbootapachecxfdemo.impl.WeatherServiceImpl;
import de.codecentric.namespace.weatherservice.WeatherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(ServiceConfig.class)
public class ServiceTestConfig {
    @Bean
    public WeatherService weatherService(){
        return new WeatherServiceImpl();
    }
}
