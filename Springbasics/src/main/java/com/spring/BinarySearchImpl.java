package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // tells spring this is a bean
public class BinarySearchImpl {
	
	@Autowired
	private SortAlgorithm sortAlgorithm;
	
	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}

	//Sorting an Array
	//searth the array
	//return the result
	
	
	public int binarySearch(int[] numbers, int numberToSearchFor) {
		
		int[] sorted = sortAlgorithm.sort(numbers);
		//Bubble Sort Algorithm
		//Quick Sort Algorithm
		return 3;
	}
	
}
 