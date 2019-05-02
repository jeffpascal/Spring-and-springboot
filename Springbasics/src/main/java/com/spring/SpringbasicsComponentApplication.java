package com.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.componentscan.ComponentPersonDAO;

@Configuration
@ComponentScan("com.spring.componentscan")
public class SpringbasicsComponentApplication {
	
	static Logger LOGGER = LoggerFactory.getLogger(SpringbasicsComponentApplication.class);
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringbasicsComponentApplication.class);
				//SpringApplication.run(SpringbasicsComponentApplication.class, args);

		ComponentPersonDAO dao = applicationContext.getBean(ComponentPersonDAO.class);
		ComponentPersonDAO dao1 = applicationContext.getBean(ComponentPersonDAO.class);
		LOGGER.info("PREdESTROY");
		applicationContext.close();
	}
	
	/*@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct");
		LOGGER.info("postConstruct");
		
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("PREdESTROY");
		LOGGER.info("PREdESTROY");
	}*/

}
