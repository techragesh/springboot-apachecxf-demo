package com.techjava.springbootapachecxfdemo.config;

import com.techjava.springbootapachecxfdemo.impl.WeatherServiceImpl;
import de.codecentric.namespace.weatherservice.WeatherService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class ServiceConfig {

    public static final String BASE_URL= "/soap-api";
    public static final String SERVICE_URL = "/WeatherSoapService_1.0";

    @Bean
    public ServletRegistrationBean registrationBean(){
        return new ServletRegistrationBean(new CXFServlet(),BASE_URL + "/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus(){
        return new SpringBus();
    }

    @Bean
    public WeatherService weatherService(){
        return new WeatherServiceImpl();
    }

    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint =  new EndpointImpl(springBus(), weatherService());
        endpoint.publish(SERVICE_URL);
        endpoint.setWsdlLocation("weather.wsdl");
        return endpoint;
    }
}
