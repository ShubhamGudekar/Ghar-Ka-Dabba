package com.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerController {

	@GetMapping
	public String getAllCustomers() {
		System.out.println("in customer controller");
		return "in customer controller";
	}
	
}
