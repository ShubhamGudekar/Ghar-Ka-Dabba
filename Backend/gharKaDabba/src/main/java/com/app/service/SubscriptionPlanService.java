package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.SubscriptionPlanDto;
import com.app.dto.TiffinDetailDto;
import com.app.dto.UserDetailsDto;

public interface SubscriptionPlanService {

	SubscriptionPlanDto addNewSubscriptionPlan(SubscriptionPlanDto SubscriptionPlanDto);

	List<SubscriptionPlanDto> getAllSubscriptionPlans();

	SubscriptionPlanDto getSubscriptionPlanById(long id);

	String removeSubscriptionPlan(long id);

	String editSubscriptionDetails(SubscriptionPlanDto SubscriptionPlanDto);
	
	
	
}
