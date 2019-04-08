package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbasicsApplication {
	
	
	//What are the beans that spring needs to manage
	//What are the dependencies for a bean?
	//Where to search for beans
	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = SpringApplication.run(SpringbasicsApplication.class, args);
	
		//BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		
		//Application context
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		
		int result = binarySearch.binarySearch(new int[] {1, 2,3,4,5}, 2);
		System.out.println(result);
	
	}

}
