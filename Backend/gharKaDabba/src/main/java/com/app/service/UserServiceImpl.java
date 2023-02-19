package com.app.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.NewUserDto;
import com.app.dto.UserDetailsDto;
import com.app.entities.UserEntity;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ImageHandlingService imageService;

	@Override
	public String registerNewUser(NewUserDto newUserDto) {
		UserEntity user = userRepo.save(mapper.map(newUserDto, UserEntity.class));
		return "User Registered Successfully with UserID : " + user.getId();
	}

	@Override
	public List<UserDetailsDto> getAllUser() {
		return userRepo.findAll().stream().map(u -> mapper.map(u, UserDetailsDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDetailsDto getUser(long id) {
		UserEntity user = userRepo.findById(id).orElseThrow();
		return mapper.map(user, UserDetailsDto.class);
	}

	@Override
	public String removeUser(long id) {
		UserEntity user = userRepo.findById(id).orElseThrow();
		userRepo.delete(user);
		return "User Deleted Successfully";
	}

	@Override
	public String updateUser(UserDetailsDto userDetailsDto) {
		UserEntity user = userRepo.findById(userDetailsDto.getId()).orElseThrow();
		user.setFirstName(userDetailsDto.getFisrtName());
		user.setLastName(userDetailsDto.getLastName());
		user.setEmail(userDetailsDto.getEmail());
		user.setMobile(user.getMobile());
		return "User Details Updated Successfully";
	}

	@Override
	public String uploadImage(long id, MultipartFile imageFile) throws IOException {
		UserEntity user = userRepo.findById(id).orElseThrow();
		user.setProfileImage(imageService.uploadImage(imageFile));
		return "Image Uploaded Successfully";
	}

	@Override
	public byte[] getImage(Long id) throws IOException {
		UserEntity user = userRepo.findById(id).orElseThrow();
		return imageService.getImage(user.getProfileImage());
		
	}
	
	
	
}
