package com.app.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.AddressDto;
import com.app.dto.EditUserDetailsDto;
import com.app.dto.CustDetailsDto;
import com.app.entities.Address;
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
	public List<CustDetailsDto> getAllCustomers() {
		List<CustDetailsDto> details=customerRepo.findAll().stream().map(cust -> mapper.map(cust, CustDetailsDto.class))
				.collect(Collectors.toList());
		return details;
	}

	@Override
	public CustDetailsDto getCustomerById(long id) {
		Customer customer = customerRepo.findById(id).orElseThrow();
		return mapper.map(customer, CustDetailsDto.class);
	}

	@Override
	public String removeCustomer(long id) {
		Customer customer = customerRepo.findById(id).orElseThrow();
		Login loginDetails = loginService.findByEmail(customer.getEmail());
		customerRepo.delete(customer);
		loginService.removeLogin(loginDetails);
		return "Customer Deleted Successfully";
	}

	@Override
	public String editCustomerDetails(EditUserDetailsDto userDetailsDto) {
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

	// customer want to upload his/her profile pic
	@Override
	public String uploadImage(Long id, MultipartFile imageFile) throws IOException {
		Customer customer = customerRepo.findById(id).orElseThrow();
		customer.setProfileImage(imageService.uploadImage(imageFile));
		return "Image Uploaded Successfully";
	}

	// get the image path from server side
	@Override
	public byte[] getImage(Long id) throws IOException {
		Customer customer = customerRepo.findById(id).orElseThrow();
		return imageService.getImage(customer.getProfileImage());
	}

	@Override
	public String addDeliveryAddress(AddressDto address, Long id) {
		Customer customer = customerRepo.findById(id).orElseThrow();
		customer.getDeliveryAddress().add(mapper.map(address, Address.class));
		return "Address Added Successfully";
	}

	@Override
	public List<AddressDto> getDeliveryAddress(Long id) {
		Customer customer = customerRepo.findById(id).orElseThrow();
		return customer.getDeliveryAddress().stream().map(add -> mapper.map(add, AddressDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public String updateDeliveryAddress(Set<AddressDto> addressDto,Long id) {
		Customer customer = customerRepo.findById(id).orElseThrow();
		Set<Address> addresses = addressDto.stream().map(add -> mapper.map(add, Address.class))
				.collect(Collectors.toSet());
		customer.setDeliveryAddress(addresses);
		return "Address Updated Successfully";
	}

}
