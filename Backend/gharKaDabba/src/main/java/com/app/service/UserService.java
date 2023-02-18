package com.app.service;

import java.util.List;

import com.app.dto.NewUserDto;
import com.app.dto.UserDetailsDto;
import com.app.entities.User;

public interface UserService {

	String registerNewUser(NewUserDto newUserDto);
	
	List<UserDetailsDto> getAllUser();
	
	UserDetailsDto getUser(long id);

	String removeUser(long id);

	String updateUser(User user);
	
}
