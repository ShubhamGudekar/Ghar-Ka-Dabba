package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SubscriptionPlanDto;
import com.app.service.SubscriptionPlanService;

@RestController
@CrossOrigin
@RequestMapping("/subscription")
// http://localhost8080/subscription

public class SubscriptionPlanController {

	@Autowired
	private SubscriptionPlanService SubscriptionPlanService;

	@GetMapping("/allplans")
	public ResponseEntity<?> getAllSubscriptionPlans() {
		return new ResponseEntity<>(SubscriptionPlanService.getAllSubscriptionPlans(), HttpStatus.OK);
	}

	@GetMapping("/plan/{id}")
	public ResponseEntity<?> getSubscriptionPlanById(@PathVariable long id) {
		return new ResponseEntity<>(SubscriptionPlanService.getSubscriptionPlanById(id), HttpStatus.OK);
	}

	@PostMapping("/newplan/{vendorId}")
	public ResponseEntity<?> addNewSubscriptionPlan(@RequestBody SubscriptionPlanDto SubscriptionPlanDto,
			@PathVariable Long vendorId) {
		return new ResponseEntity<>(SubscriptionPlanService.addNewSubscriptionPlan(SubscriptionPlanDto, vendorId),
				HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<?> updateSubscriptionPlan(@RequestBody SubscriptionPlanDto SubscriptionPlanDto) {
		return new ResponseEntity<>(SubscriptionPlanService.editSubscriptionDetails(SubscriptionPlanDto),
				HttpStatus.OK);
	}

	@GetMapping("/{id}/deactivate")
	public ResponseEntity<?> deactivatePlanById(@PathVariable long id) {
		return new ResponseEntity<>(SubscriptionPlanService.deactivatePlanById(id), HttpStatus.OK);
	}

	@GetMapping("/{id}/activate")
	public ResponseEntity<?> activatePlanById(@PathVariable long id) {
		return new ResponseEntity<>(SubscriptionPlanService.activatePlanById(id), HttpStatus.OK);
	}

	@GetMapping("getAllAvaliablePlans")
	public ResponseEntity<?> getAllActivatePlans() {
		return new ResponseEntity<>(SubscriptionPlanService.getAllAvaliablePlans(), HttpStatus.OK);
	}

	@GetMapping("getAllNotAvaliablePlans")
	public ResponseEntity<?> getAllNonActivatePlans() {
		return new ResponseEntity<>(SubscriptionPlanService.getAllNotAvaliablePlans(), HttpStatus.OK);
	}
}
