package com.app.dto;

import com.app.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class NewUserDto {

	private String fisrtName;

	private String lastName;

	private String email;

	private String mobile;

	private String password;

	private UserRole userRole;
}
