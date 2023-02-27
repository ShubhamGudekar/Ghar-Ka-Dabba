package com.app.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer_plans")
@NoArgsConstructor
public class CustomerPlanSubscription extends BaseEntity {
	
//	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@CreationTimestamp
	private LocalDate startDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")	
	private LocalDate endDate;
	
	
	//constructor
	public CustomerPlanSubscription(String startDate, String endDate) {
		super();
		this.startDate = LocalDate.parse(startDate);
		this.endDate = LocalDate.parse(endDate);
	}

	@ManyToOne
	@JoinColumn(name = "subcription_id")
	private SubscriptionPlan plan;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer ;

}
