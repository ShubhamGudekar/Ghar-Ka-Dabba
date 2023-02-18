package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.NewUserDto;
import com.app.dto.UserDetailsDto;
import com.app.entities.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public String registerNewUser(NewUserDto newUserDto) {
		User user = userRepo.save(mapper.map(newUserDto, User.class));
		return "User Registered Successfully with UserID : " + user.getId();
	}

	@Override
	public List<UserDetailsDto> getAllUser() {
		return userRepo.findAll().stream().map(u -> mapper.map(u, UserDetailsDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDetailsDto getUser(long id) {
		User user = userRepo.findById(id).orElseThrow();
		return mapper.map(user, UserDetailsDto.class);
	}

	@Override
	public String removeUser(long id) {
		User user = userRepo.findById(id).orElseThrow();
		userRepo.delete(user);
		return "User Deleted Successfully";
	}

	@Override
	public String updateUser(User user) {
		userRepo.save(user);
		return "User Details Updated Successfully";
	}

}
