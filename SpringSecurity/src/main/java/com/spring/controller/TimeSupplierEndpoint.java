package com.spring.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeSupplierEndpoint {

	@GetMapping(path = "/time", produces = "application/json")
	public LocalDate currentTime() {
		return LocalDate.MAX;
	}
	
	@GetMapping(path = "/secretTime", produces = "application/json")
	public LocalDate secretCurrentTime() {
		return LocalDate.now();
	}
}
