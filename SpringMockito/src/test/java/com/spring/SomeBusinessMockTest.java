package com.spring;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
	
	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	SomeBusinessImpl businessImpl;
	
	@Test
	public void findTheGreatestFromAllData() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24,14,2});
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(24,result);
	}
}
