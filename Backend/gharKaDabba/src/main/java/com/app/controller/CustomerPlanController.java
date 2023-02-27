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

import com.app.dto.CustomerPlanDto;
import com.app.dto.SubscriptionPlanDto;
import com.app.dto.UserRegResponse;
import com.app.service.CustomerPlanService;

@RestController
@CrossOrigin
@RequestMapping("/customerplan")
public class CustomerPlanController {

	@Autowired
	private CustomerPlanService CustomerPlanService;
	
	@GetMapping("/allplans")
	public ResponseEntity<?> getAllCustomerPlans() {
		return new ResponseEntity<>(CustomerPlanService.getAllCustomerPlans(), HttpStatus.OK);
	}

	@GetMapping("/plan/{id}")
	public ResponseEntity<?> getCustomerPlanById(@PathVariable long id) {
		return new ResponseEntity<>(CustomerPlanService.getCustomerPlanById(id), HttpStatus.OK);
	}
	
	@PostMapping("/newplan")
	public ResponseEntity<?> addNewCustomerPlan(@RequestBody CustomerPlanDto CustomerPlanDto) {
		CustomerPlanDto newCustomerPlanDto=CustomerPlanService.addNewCustomerPlan(CustomerPlanDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new UserRegResponse("new subscription added Successfully Id Generated : " + newCustomerPlanDto.getId()));

	}

	@PutMapping
	public ResponseEntity<?> updateCustomerPlan(@RequestBody CustomerPlanDto CustomerPlanDto) {
		return new ResponseEntity<>(CustomerPlanService.editCustomerPlanDetails(CustomerPlanDto),HttpStatus.OK);
	}

	
	
}
