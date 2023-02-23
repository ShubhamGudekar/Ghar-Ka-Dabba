package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
		Login login = loginRepo.findByEmail(changePasswordDto.getEmail()).orElseThrow();
		
		
		System.out.println("db pass : "+login.getPassword());
		System.out.println("ne pass : "+encoder.encode(changePasswordDto.getOldPassword()));
		
		if (login.getPassword().equals(encoder.encode(changePasswordDto.getOldPassword()))) {
			
			login.setPassword(encoder.encode(changePasswordDto.getNewPassword()));
			return "Password Updated Successfully";
		}
		throw new RuntimeException("Invalid Password");
	}

}
