package com.simpletest;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyMathTest {

	MyMath myMath = new MyMath();
	
	@Before
	public void before() {
		System.out.println("Before ");
	}
	
	@Test
	public void sum_with3numbers() {
		System.out.println("Test 1");
		assertEquals(myMath.sum(new int[] { 1,2,3 }), 6);
	}
	
	@Test
	public void sum_with0numbers() {
		System.out.println("Test 2");
		assertEquals(myMath.sum(new int[] {}), 0);
	}
	
	@Test
	public void sum_with1numbers() {
		System.out.println("Test 3");
		assertEquals(myMath.sum(new int[] { 3 }), 3);
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}

}
