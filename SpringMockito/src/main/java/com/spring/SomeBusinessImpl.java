package com.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class SomeBusinessImpl {
	
	private DataService dataService;
	
	public SomeBusinessImpl(DataService dataServiceStub) {
		this.dataService = dataServiceStub;
	}
	

	//get some data and find out the biggest of them
	int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatest = Integer.MIN_VALUE;
		
		for(int value : data) {
			if(value>greatest) {
				greatest = value;
			}
				
		}
		return greatest;
	}
}

