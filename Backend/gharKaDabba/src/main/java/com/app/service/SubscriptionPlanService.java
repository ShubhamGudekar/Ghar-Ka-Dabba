package com.app.service;

import java.util.List;

import com.app.dto.SubscriptionPlanDto;

public interface SubscriptionPlanService {

	String addNewSubscriptionPlan(SubscriptionPlanDto SubscriptionPlanDto, Long vendorId);

	List<SubscriptionPlanDto> getAllSubscriptionPlans();

	SubscriptionPlanDto getSubscriptionPlanById(long id);

	String editSubscriptionDetails(SubscriptionPlanDto SubscriptionPlanDto);

	String deactivatePlanById(long id);

	String activatePlanById(long id);

	List<SubscriptionPlanDto> getAllAvaliablePlans();
	
	List<SubscriptionPlanDto> getAllNotAvaliablePlans();

}
