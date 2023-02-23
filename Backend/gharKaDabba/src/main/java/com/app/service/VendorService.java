package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.UserDetailsDto;

public interface VendorService {

	String approveVendor(long id);

	List<UserDetailsDto> getAllVendors();

	UserDetailsDto getVendorById(long id);

	String removeVendor(long id);

	String editVendorDetails(UserDetailsDto userDetailsDto);

	String uploadImage(Long id, MultipartFile imageFile) throws IOException;

	byte[] getImage(Long id) throws IOException;
	
}
