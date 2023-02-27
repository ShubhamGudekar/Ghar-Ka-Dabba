package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dto.ChangePasswordDto;
import com.app.entities.Login;
import com.app.repository.LoginRepository;

@Transactional
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepo;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private AuthenticationManager manager;

	@Override
	public Login findByEmail(String email) {
		return loginRepo.findByEmail(email).orElseThrow();
	}

	@Override
	public void removeLogin(Login loginDetails) {
		loginRepo.delete(loginDetails);

	}

	@Override
	public void addLogin(Login login) {
		loginRepo.save(login);
	}

	@Override
	public String changePassword(ChangePasswordDto changePasswordDto) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
				changePasswordDto.getEmail(), changePasswordDto.getOldPassword());
		// authenticate the credentials
		manager.authenticate(authToken);

		Login login = loginRepo.findByEmail(changePasswordDto.getEmail()).orElseThrow();
		login.setPassword(encoder.encode(changePasswordDto.getNewPassword()));
		
		return "Password Updated Successfully";
	}

}
