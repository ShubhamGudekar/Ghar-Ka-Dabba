package com.app.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.enums.PlanType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionPlanDto {
	
	private Long id;

	private String name;
	
	private String description;
	
	private double price;
	
	private PlanType planType;
}
