package com.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.spring.properties.SomeExternalService;
import com.spring.scope.PersonDAO;

@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class SpringbasicsExternalPropertiesApplication {

	static Logger LOGGER = LoggerFactory.getLogger(SpringbasicsExternalPropertiesApplication.class);

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringbasicsExternalPropertiesApplication.class)) {

			SomeExternalService service = applicationContext.getBean(SomeExternalService.class);
			System.out.println(service.returnServiceURL());

			
		}

	}

}
