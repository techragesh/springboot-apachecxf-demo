package com.techjava.springbootapachecxfdemo.config;

import de.codecentric.namespace.weatherservice.WeatherService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientTestConfig {

    @Bean
    public WeatherService weatherServiceTestClient(){
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(WeatherService.class);
        jaxWsProxyFactoryBean.setAddress("http://localhost:8085"+ ServiceConfig.BASE_URL + ServiceConfig.SERVICE_URL);
        return (WeatherService) jaxWsProxyFactoryBean.create();
    }
}
