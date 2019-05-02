package com.simpletest;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssertTest {

	@Test
	public void test() {
		boolean trueCondition = true;
		assertEquals(1,1);
		assertTrue(trueCondition);
		assertFalse(!trueCondition);
		assertNull(null);
		assertNotNull(trueCondition);
		assertArrayEquals(new int[] {1,2}, new int[] {1,2});
	}

}
