package com.spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringbasicsApplication {
	
	
	//What are the beans that spring needs to manage
	//What are the dependencies for a bean?
	//Where to search for beans
	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(SpringbasicsApplication.class);
				//SpringApplication.run(SpringbasicsApplication.class, args);
	
		//BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		
		//Application context
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearch.binarySearch(new int[] {1, 2,3,4,5}, 2);
		System.out.println(binarySearch);
		System.out.println(binarySearch1);
	
	}

}
