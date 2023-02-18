package com.app.dto;

import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {

	private Long id;
	
	private int version;
	
	private String fisrtName;

	private String lastName;

	private String email;

	private String mobile;

	private Role userRole;
	
}
