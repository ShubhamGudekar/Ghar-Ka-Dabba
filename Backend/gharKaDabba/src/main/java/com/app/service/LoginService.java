package com.app.service;

import com.app.dto.ChangePasswordDto;
import com.app.entities.Login;

public interface LoginService {
	
	Login findByEmail(String email);

	void removeLogin(Login loginDetails);

	void addLogin(Login login);

	String changePassword(ChangePasswordDto changePasswordDto);


	
}
