package com.simpletest;

public class MyMath {
	public int sum(int[] numbers) {
		int sum = 0;
		for(int i : numbers) {
			sum = sum + i;
		}
		return sum;
	}
}
