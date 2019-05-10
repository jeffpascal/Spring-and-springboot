package com.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SomeBusinessStubTest {
	
	@Test
	public void findTheGreatestFromAllData() {
		SomeBusinessImpl bus= new SomeBusinessImpl(new DataServiceStub());
		int result = bus.findTheGreatestFromAllData();
		assertEquals(3,result);
	}
}



class DataServiceStub implements DataService{
	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {3,1,2};
	}
}