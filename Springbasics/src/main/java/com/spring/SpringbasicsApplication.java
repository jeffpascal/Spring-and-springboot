package com.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.scope.PersonDAO;

@Configuration
@ComponentScan("com.spring.scope")
public class SpringbasicsApplication {

	static Logger LOGGER = LoggerFactory.getLogger(SpringbasicsApplication.class);

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringbasicsComponentApplication.class)) {

			PersonDAO dao = applicationContext.getBean(PersonDAO.class);
			PersonDAO dao1 = applicationContext.getBean(PersonDAO.class);

			LOGGER.info("{}", dao);
			LOGGER.info("{}", dao.getJdbcConnection());
			LOGGER.info("{}", dao1);
			LOGGER.info("{}", dao.getJdbcConnection());
			
		}

	}

}
