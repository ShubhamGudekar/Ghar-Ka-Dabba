package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.CustomerPlanSubscription;
import com.app.entities.SubscriptionPlan;
import com.app.entities.Tiffin;
import com.app.entities.Vendor;
import com.app.dto.SubscriptionPlanDto;
import com.app.dto.UserDetailsDto;
import com.app.entities.SubscriptionPlan;
import com.app.enums.PlanType;
import com.app.repository.CustomerPlanRepository;
import com.app.repository.SubscriptionRepository;
import com.app.repository.VendorRepository;
@Service
@Transactional
public class SubscriptionPlanServiceImpl implements SubscriptionPlanService {
	
	@Autowired
	private VendorRepository vendorRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private SubscriptionRepository subscrprepo;

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private CustomerPlanRepository custplanrepo;
		
//	private String name;
//	
//	private String description;
//	
//	private double price;
//	
//	private PlanType planType;

	//add new subscription plan
	@Override
	public SubscriptionPlanDto addNewSubscriptionPlan(SubscriptionPlanDto SubscriptionPlanDto) {
		SubscriptionPlan newsubscrpplan=new SubscriptionPlan(SubscriptionPlanDto.getName(),SubscriptionPlanDto.getDescription(),SubscriptionPlanDto.getPrice(),SubscriptionPlanDto.getPlanType());
		SubscriptionPlan plan =subscrprepo.save(newsubscrpplan);
		// TODO Auto-generated method stub
		return mapper.map(plan,SubscriptionPlanDto.class);
	}

	//get all subscription plans
	@Override
	public List<SubscriptionPlanDto> getAllSubscriptionPlans() {
		// TODO Auto-generated method stub
		return subscrprepo.findAll().stream().map(subsc -> mapper.map(subsc, SubscriptionPlanDto.class))
				.collect(Collectors.toList());
	}

	//get individual subscription plan
	@Override
	public SubscriptionPlanDto getSubscriptionPlanById(long id) {
		// TODO Auto-generated method stub
		SubscriptionPlan subscriptionplan = subscrprepo.findById(id).orElseThrow();
		return mapper.map(subscriptionplan, SubscriptionPlanDto.class);
	}

	//remove subscription plan
	@Override
	public String removeSubscriptionPlan(long id) {
//		// TODO Auto-generated method stub
//		SubscriptionPlan subscriptionplan=subscrprepo.findById(id).orElseThrow();
//		CustomerPlanSubscription customerplansubscription= custplanrepo.findById(id).orElseThrow();
//		Tiffin tiffin=tiffinrepo.findById(subscriptionplan.getName()).orElseThrow();
//		subscrprepo.delete(subscriptionplan);
//		custplanrepo.delete(customerplansubscription);
//		tiffinrepo.delete(tiffin);
		return null;
	}

	//edit an subscription plan
	@Override
	public String editSubscriptionDetails(SubscriptionPlanDto SubscriptionPlanDto) {
		// TODO Auto-generated method stub
		SubscriptionPlan subscriptionplan = subscrprepo.findById(SubscriptionPlanDto.getId()).orElseThrow();
		subscriptionplan.setName(SubscriptionPlanDto.getName());
		subscriptionplan.setDescription(SubscriptionPlanDto.getDescription());
		subscriptionplan.setPrice(SubscriptionPlanDto.getPrice());
		subscriptionplan.setPlanType(SubscriptionPlanDto.getPlanType());
		return "subscription plan updated successfully!";
//		this.name = name;
//		this.description = description;
//		this.price = price;
//		this.planType = planType;		
	}

}
