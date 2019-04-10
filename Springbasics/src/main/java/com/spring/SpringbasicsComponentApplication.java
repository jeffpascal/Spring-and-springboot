package com.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.basic.BinarySearchImpl;
import com.spring.componentscan.ComponentPersonDAO;
import com.spring.scope.PersonDAO;

@SpringBootApplication
@ComponentScan("com.spring.componentscan")
public class SpringbasicsComponentApplication {
	
	static Logger LOGGER = LoggerFactory.getLogger(SpringbasicsComponentApplication.class);
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringbasicsComponentApplication.class, args);

		ComponentPersonDAO dao = applicationContext.getBean(ComponentPersonDAO.class);
		ComponentPersonDAO dao1 = applicationContext.getBean(ComponentPersonDAO.class);
		
		LOGGER.info("{}", dao);
		LOGGER.info("{}", dao.getJdbcConnection());
		LOGGER.info("{}", dao1);
		LOGGER.info("{}", dao.getJdbcConnection());
	}

}
