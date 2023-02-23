package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer_plans")
public class CustomerPlanSubcription extends BaseEntity {
	
	@CreationTimestamp
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name = "subcription_id")
	private SubcriptionPlan plan;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer ;

}
