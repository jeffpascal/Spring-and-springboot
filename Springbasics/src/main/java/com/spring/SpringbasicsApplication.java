package com.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.basic.BinarySearchImpl;
import com.spring.scope.PersonDAO;

@SpringBootApplication
public class SpringbasicsApplication {
	
	static Logger LOGGER = LoggerFactory.getLogger(SpringbasicsApplication.class);
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringbasicsApplication.class, args);

		PersonDAO dao = applicationContext.getBean(PersonDAO.class);
		PersonDAO dao1 = applicationContext.getBean(PersonDAO.class);
		
		LOGGER.info("{}", dao);
		LOGGER.info("{}", dao.getJdbcConnection());
		LOGGER.info("{}", dao1);
		LOGGER.info("{}", dao.getJdbcConnection());
	}

}
