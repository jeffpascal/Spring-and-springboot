package com.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.xml.XmlPersonDAO;

public class SpringbasicsXMLContextApplication {
		static Logger LOGGER = LoggerFactory.getLogger(SpringbasicsComponentApplication.class);
		public static void main(String[] args) {
		try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml")) {
			
			
			LOGGER.info("beans loaded: -> {}", (Object)applicationContext.getBeanDefinitionNames());
			//[xmlJdbcConnection, xmlPersonDao]
			XmlPersonDAO personDao = applicationContext.getBean(XmlPersonDAO.class);
			System.out.println(personDao);
			System.out.println(personDao.getXmlJdbcConnection());
			
		}

	}

}
