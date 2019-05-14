package com.spring.basic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

//load context
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=SpringbasicsApplication.class)
public class BinarySearchTest {

	//get this bean from context
	@Autowired
	BinarySearchImpl binarySearch;
	
	@Test
	public void testBasicScenario() {
		//check if value is correct
		int actualResult = binarySearch.binarySearch(new int[] {}, 4);
		//check if value is correct
		assertEquals(3, actualResult);
		//call method on binarySearch
		
		
	}

}
