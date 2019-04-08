package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbasicsApplication {
	
	
	//What are the beans that spring needs to manage
	//What are the dependencies for a bean?
	//Where to search for beans
	public static void main(String[] args) {
		
		
		SpringApplication.run(SpringbasicsApplication.class, args);
	
		BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		int result = binarySearch.binarySearch(new int[] {3,1,2,3},4);
		System.out.println(result);
	
	}

}
