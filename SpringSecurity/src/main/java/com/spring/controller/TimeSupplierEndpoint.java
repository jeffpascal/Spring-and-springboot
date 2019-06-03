package com.spring.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeSupplierEndpoint {

	@GetMapping(value = "/time", produces = "application/json")
	public String currentTime() {
		return "varza";
	}
	
	@GetMapping(value = "/secretTime", produces = "application/json")
	public LocalDate secretCurrentTime() {
		return LocalDate.now();
	}
}