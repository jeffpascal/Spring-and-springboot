package com.spring.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype") // makes the bean prototype(which means every time it is created, it gives a new instance instead of the same one
@Component // tells spring this is a bean
public class BinarySearchImpl {
	
	@Autowired
	@Qualifier("quick")
	private SortAlgorithm quickSortAlgorithm;
	
	public int binarySearch(int[] numbers, int numberToSearchFor) {
		System.out.println(quickSortAlgorithm);
		int[] sorted = quickSortAlgorithm.sort(numbers);
		
		//Bubble Sort Algorithm
		//Quick Sort Algorithm
		return 3;
	}
	
}
 