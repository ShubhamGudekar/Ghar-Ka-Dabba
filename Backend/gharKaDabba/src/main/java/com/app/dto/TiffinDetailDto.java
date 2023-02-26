package com.app.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.app.enums.FoodType;
import com.app.enums.UserRole;
import com.app.enums.WeekDayAndTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TiffinDetailDto {
	
	private String Name;

	private double price;
	
	private String description;
	
	private FoodType foodType;
	
	private WeekDayAndTime day;
	
	private String ImagePath;

}
