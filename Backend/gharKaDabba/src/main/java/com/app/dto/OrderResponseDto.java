package com.app.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResponseDto {

	private Long id;
	
	private LocalDateTime dateTime;
	
	private long customerId;
	
	private double paymentAmount;
	
	private List<Long> planIds;
	
}
