package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.NewUserDto;
import com.app.dto.UserDetailsDto;

public interface UserService {

	String registerNewUser(NewUserDto newUserDto);
	
	List<UserDetailsDto> getAllUser();
	
	UserDetailsDto getUser(long id);

	String removeUser(long id);

	String updateUser(UserDetailsDto user);
	
	String uploadImage(long id,MultipartFile imageFile) throws IOException;

	byte[] getImage(Long id) throws IOException;
	
}
