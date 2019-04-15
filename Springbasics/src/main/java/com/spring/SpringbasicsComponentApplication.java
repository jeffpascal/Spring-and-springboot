package com.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.componentscan.ComponentPersonDAO;

@Configuration
@ComponentScan("com.spring.componentscan")
public class SpringbasicsComponentApplication {
	
	//static Logger LOGGER = LoggerFactory.getLogger(SpringbasicsComponentApplication.class);
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringbasicsComponentApplication.class);
				//SpringApplication.run(SpringbasicsComponentApplication.class, args);

		ComponentPersonDAO dao = applicationContext.getBean(ComponentPersonDAO.class);
		ComponentPersonDAO dao1 = applicationContext.getBean(ComponentPersonDAO.class);
		
		//LOGGER.info("{}", dao);
		//LOGGER.info("{}", dao.getJdbcConnection());
		//LOGGER.info("{}", dao1);
		//LOGGER.info("{}", dao.getJdbcConnection());
		System.out.println(dao);
		System.out.println(dao.getJdbcConnection());
		System.out.println(dao1);
		System.out.println(dao.getJdbcConnection());
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
