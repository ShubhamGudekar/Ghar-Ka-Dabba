package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SubscriptionPlanDto;
import com.app.dto.UserDTO;
import com.app.dto.UserDetailsDto;
import com.app.dto.UserRegResponse;
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

//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> removeUser(@PathVariable long id) {
//		return new ResponseEntity<>(SubscriptionPlanService.removeSubscriptionPlan(id), HttpStatus.OK);
//	}
	
	@PostMapping("/newplan")
	public ResponseEntity<?> addNewSubscriptionPlan(@RequestBody SubscriptionPlanDto SubscriptionPlanDto) {
//	    System.out.println("in new subscribe controller");
		SubscriptionPlanDto newSubscriptionPlanDto=SubscriptionPlanService.addNewSubscriptionPlan(SubscriptionPlanDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new UserRegResponse("new subscription added Successfully Id Generated : " + newSubscriptionPlanDto.getId()));

	}

	@PutMapping
	public ResponseEntity<?> updateSubscriptionPlan(@RequestBody SubscriptionPlanDto SubscriptionPlanDto) {
		return new ResponseEntity<>(SubscriptionPlanService.editSubscriptionDetails(SubscriptionPlanDto), HttpStatus.OK);
	}

}
