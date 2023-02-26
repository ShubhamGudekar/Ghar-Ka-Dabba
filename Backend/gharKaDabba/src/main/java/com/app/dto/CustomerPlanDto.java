package com.app.dto;

import java.time.LocalDate;

import com.app.enums.PlanType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerPlanDto {
	
	private Long id;

	private LocalDate startDate;
	
	private LocalDate endDate;


}
