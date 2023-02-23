package com.app.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.UserDetailsDto;
import com.app.entities.Customer;
import com.app.entities.Login;
import com.app.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private ImageHandlingService imageService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<UserDetailsDto> getAllCustomers() {
		return customerRepo.findAll().stream().map(cust -> mapper.map(cust, UserDetailsDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public UserDetailsDto getCustomerById(long id) {
		Customer customer= customerRepo.findById(id).orElseThrow();
		return mapper.map(customer,UserDetailsDto.class);
	}

	@Override
	public String removeCustomer(long id) {
		Customer customer = customerRepo.findById(id).orElseThrow();
		Login loginDetails=loginService.findByEmail(customer.getEmail());
		customerRepo.delete(customer);
		loginService.removeLogin(loginDetails);
		return "Customer Deleted Successfully";
	}

	@Override
	public String editCustomerDetails(UserDetailsDto userDetailsDto) {
		Customer customer = customerRepo.findById(userDetailsDto.getId()).orElseThrow();
		customer.setFirstName(userDetailsDto.getFirstName());
		customer.setLastName(userDetailsDto.getLastName());

		if (!customer.getEmail().equals(userDetailsDto.getEmail())) {
			Login loginDetails = loginService.findByEmail(customer.getEmail());
			customer.setEmail(userDetailsDto.getEmail());
			loginDetails.setEmail(userDetailsDto.getEmail());
		}
		customer.setMobile(userDetailsDto.getMobile());

		return "Customer Details Updated Successfully";
	}

	@Override
	public String uploadImage(Long id, MultipartFile imageFile) throws IOException {
		Customer customer = customerRepo.findById(id).orElseThrow();
		customer.setProfileImage(imageService.uploadImage(imageFile));
		return "Image Uploaded Successfully";
	}

	@Override
	public byte[] getImage(Long id) throws IOException {
		Customer customer = customerRepo.findById(id).orElseThrow();
		return imageService.getImage(customer.getProfileImage());
	}

}
