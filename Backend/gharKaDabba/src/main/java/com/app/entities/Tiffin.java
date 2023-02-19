package com.app.entities;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.enums.FoodType;
import com.app.enums.WeekDayAndTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tiffin{

	private String name;
	 
	private double price;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private FoodType foodType;
	
	@Enumerated(EnumType.STRING)
	private WeekDayAndTime day;
	
	private String ImagePath;
	
	
	
}
