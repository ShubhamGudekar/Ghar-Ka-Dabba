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
import com.app.entities.Login;
import com.app.entities.Vendor;
import com.app.repository.VendorRepository;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository vendorRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ImageHandlingService imageService;

	@Autowired
	private LoginService loginService;

	@Override
	public String approveVendor(long id) {
		Vendor vendor = vendorRepo.findById(id).orElseThrow();
		vendor.setVerified(true);
		return "Vendor Approved Successfully";
	}

	@Override
	public List<UserDetailsDto> getAllVendors() {

		return vendorRepo.findAll().stream().map(ven -> mapper.map(ven, UserDetailsDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public UserDetailsDto getVendorById(long id) {
		Vendor vendor = vendorRepo.findById(id).orElseThrow();
		return mapper.map(vendor, UserDetailsDto.class);
	}

	@Override
	public String removeVendor(long id) {
		Vendor vendor = vendorRepo.findById(id).orElseThrow();
		Login loginDetails=loginService.findByEmail(vendor.getEmail());
		vendorRepo.delete(vendor);
		loginService.removeLogin(loginDetails);
		return "Vendor Deleted Successfully";
	}

	@Override
	public String editVendorDetails(UserDetailsDto userDetailsDto) {
		Vendor vendor = vendorRepo.findById(userDetailsDto.getId()).orElseThrow();
		vendor.setFirstName(userDetailsDto.getFirstName());
		vendor.setLastName(userDetailsDto.getLastName());

		if (!vendor.getEmail().equals(userDetailsDto.getEmail())) {
			Login loginDetails = loginService.findByEmail(vendor.getEmail());
			vendor.setEmail(userDetailsDto.getEmail());
			loginDetails.setEmail(userDetailsDto.getEmail());
		}

		vendor.setMobile(userDetailsDto.getMobile());
		return "Customer Details Updated Successfully";
	}

	@Override
	public String uploadImage(Long id, MultipartFile imageFile) throws IOException {
		Vendor vendor = vendorRepo.findById(id).orElseThrow();
		vendor.setProfileImage(imageService.uploadImage(imageFile));
		return "Image Uploaded Successfully";
	}

	@Override
	public byte[] getImage(Long id) throws IOException {
		Vendor vendor = vendorRepo.findById(id).orElseThrow();
		return imageService.getImage(vendor.getProfileImage());
	}

}
