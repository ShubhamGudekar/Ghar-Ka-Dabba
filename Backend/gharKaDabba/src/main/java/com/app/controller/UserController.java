package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.NewUserDto;
import com.app.dto.UserDetailsDto;
import com.app.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

	// Field Level Dependency Injection
	// Injecting UserService
	@Autowired
	private UserService userService;

	// REST end point to get all users
	// url : http://localhost:8080/users
	@GetMapping
	public ResponseEntity<?> getAllUser() {
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
	}

	// REST end point to get user by id
	// url : http://localhost:8080/users/id
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable long id) {
		return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
	}

	// REST end point to add new user
	// url : http://localhost:8080/users
	@PostMapping
	public ResponseEntity<?> registerNewUser(@RequestBody NewUserDto newUserDto) {
		return new ResponseEntity<>(userService.registerNewUser(newUserDto), HttpStatus.OK);
	}

	// REST end point to delete user
	// url : http://localhost:8080/users/id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeUser(@PathVariable long id) {
		return new ResponseEntity<>(userService.removeUser(id), HttpStatus.OK);
	}

	// REST end point to update user details
	// url : http://localhost:8080/users
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody UserDetailsDto userDetailsDto) {
		return new ResponseEntity<>(userService.updateUser(userDetailsDto), HttpStatus.OK);
	}

	// REST end point to upload image
	// url : http://localhost:8080/users/id/image
	@PostMapping(value = "/{id}/profileImage", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadProfileImage(@RequestParam MultipartFile imageFile, @PathVariable Long id)
			throws IOException {

		return new ResponseEntity<>(userService.uploadImage(id, imageFile), HttpStatus.CREATED);

	}

	// REST end point to download image
	// url : http://localhost:8080/users/id/image

	// REST end point to download/serve image
	@GetMapping(value = "/{id}/profileImage", produces = { MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE,
			MediaType.IMAGE_PNG_VALUE })
	public ResponseEntity<?> serveImageFromServerSideFolder(@PathVariable Long id) throws IOException {

		return new ResponseEntity<>(userService.getImage(id), HttpStatus.OK);
	}
}
