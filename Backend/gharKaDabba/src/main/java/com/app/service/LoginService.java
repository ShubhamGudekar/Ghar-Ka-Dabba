package com.app.service;

import com.app.dto.ChangePasswordDto;
import com.app.dto.UserDTO;
import com.app.entities.Login;

public interface LoginService {
	
	Login findByEmail(String email);

	void removeLogin(Login loginDetails);

	String addLogin(UserDTO user);

	String changePassword(ChangePasswordDto changePasswordDto);
	
	public String sendOTP(String email);
	
	public boolean validateOTP(String email,int otp);

	
}
