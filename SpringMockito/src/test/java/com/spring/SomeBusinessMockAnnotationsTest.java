package com.spring;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class SomeBusinessMockAnnotationsTest {
	
	@Test
	public void findTheGreatestFromAllData() {
		//mocking DataService
		DataService dataServiceMock = mock(DataService.class);
		//dataServiceMock.retrieveAllData() => new int[] {23,4,1}
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24,14,2});
		
		
		SomeBusinessImpl bus= new SomeBusinessImpl(dataServiceMock);
		int result = bus.findTheGreatestFromAllData();
		assertEquals(24,result);
	}
}
