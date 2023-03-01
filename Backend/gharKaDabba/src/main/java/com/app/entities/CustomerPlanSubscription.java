package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Customer customer;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "student_id")
	private SubscriptionPlan subscriptionPlan;

}
