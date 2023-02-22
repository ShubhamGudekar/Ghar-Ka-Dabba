package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.UserDTO;
import com.app.dto.UserRegResponse;
import com.app.entities.Customer;
import com.app.entities.Login;
import com.app.entities.UserEntity;
import com.app.entities.Vendor;
import com.app.enums.UserRole;
import com.app.repository.CustomerRepository;
import com.app.repository.LoginRepository;
import com.app.repository.VendorRepository;
import com.app.security.jwt_utils.JwtUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j 
public class AuthController {

	
	//Injecting Dependencies
	@Autowired
	private JwtUtils utils;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private LoginRepository loginRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private VendorRepository vendorRepo;

	@Autowired
	private PasswordEncoder encoder;

	// add a method to authenticate user . In case of success --send back token ,
	// in case of failure send back err message
	@PostMapping("/signin")
	public ResponseEntity<?> validateUserCreateToken(@RequestBody @Valid AuthRequest request) {

		// store incoming user details(not yet validated) into Authentication object
		// Authentication i/f ---> implemented by UserNamePasswordAuthToken
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getEmail(),
				request.getPassword());

		log.info("auth token " + authToken);

		// authenticate the credentials
		Authentication authenticatedDetails = manager.authenticate(authToken);

		log.info("auth token again " + authenticatedDetails);
		// => auth succcess
		return ResponseEntity.ok(new AuthResp("Auth successful!", utils.generateJwtToken(authenticatedDetails)));

	}

	
	
	// add request handling method for user registration
	@PostMapping("/signup")
	public ResponseEntity<?> userRegistration(@RequestBody @Valid UserDTO user) {

		// Extracting Role from request dto object
		UserRole role = user.getUserRole();

		// Creating an login object will be saved in database in login table if user
		// data is added
		Login login = new Login(user.getEmail(), encoder.encode(user.getPassword()), role);

		UserEntity entity = null;

		// Creating user object as per the type of role
		if (role == UserRole.ROLE_CUSTOMER) {
			// customer role
			Customer customer = new Customer(user.getFirstName(), user.getLastName(), user.getEmail(),
					user.getMobile());

			// saving in customers table
			entity = customerRepo.save(customer);
		}
		// vendor role
		else {
			Vendor vendor = new Vendor(user.getFirstName(), user.getLastName(), user.getEmail(), user.getMobile());
			// saving in vendors table
			entity = vendorRepo.save(vendor);
		}

		// adding entry to login table
		loginRepo.save(login);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new UserRegResponse("Registrstion Successfully Id Generated : " + entity.getId()));

	}
}
