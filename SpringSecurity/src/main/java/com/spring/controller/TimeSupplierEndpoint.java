package com.spring.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
public class TimeSupplierEndpoint {

	@GetMapping(path = "/admin/time", produces = "application/json")
	public LocalDate currentTime() {
		return LocalDate.MAX;
	}
	
	@GetMapping(path = "/time", produces = "application/json")
	public LocalDate lastTime() {
		return LocalDate.MIN;
	}
	
	@GetMapping(path = "/secretTime", produces = "application/json")
	public LocalDate secretCurrentTime() {
		return LocalDate.now();
	}

	@GetMapping(path = "/hello", produces = "application/json")
	public String secretCurrentTime2() {
		return "hello";
	}
}
