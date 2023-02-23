package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.UserDetailsDto;

public interface CustomerService {

	List<UserDetailsDto> getAllCustomers();

	UserDetailsDto getCustomerById(long id);

	String removeCustomer(long id);

	String editCustomerDetails(UserDetailsDto userDetailsDto);

	String uploadImage(Long id, MultipartFile imageFile) throws IOException;

	byte[] getImage(Long id) throws IOException;

}
