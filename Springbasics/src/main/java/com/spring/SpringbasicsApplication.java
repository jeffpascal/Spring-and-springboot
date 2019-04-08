package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbasicsApplication {

	public static void main(String[] args) {
		BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		int result = binarySearch.binarySearch(new int[] {3,1,2,3},4);
		System.out.println(result);
		
		SpringApplication.run(SpringbasicsApplication.class, args);
	
		
	
	}

}
