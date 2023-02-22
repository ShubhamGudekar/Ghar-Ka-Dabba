package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.VendorService;

@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private VendorService vendorService;

	@PostMapping("/vendor/{id}/approve")
	public ResponseEntity<?> approveVendor(@PathVariable Long id) {
		return new ResponseEntity<>(vendorService.approveVendor(id), HttpStatus.OK);

	}

	@GetMapping("/allvendors")
	public ResponseEntity<?> getAllVendors() {
		return new ResponseEntity<>(vendorService.getAllUser(), HttpStatus.OK);
	}

	@GetMapping("/vendor/{id}")
	public ResponseEntity<?> getVendorById(@PathVariable long id) {
		return new ResponseEntity<>(vendorService.getVendorById(id), HttpStatus.OK);

	}
}
