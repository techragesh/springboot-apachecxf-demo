package com.techjava.springbootapachecxfdemo;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.techjava.springbootapachecxfdemo")
public class SpringbootApachecxfDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApachecxfDemoApplication.class, args);
	}
}
