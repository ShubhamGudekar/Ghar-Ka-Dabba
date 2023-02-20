package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.enums.PlanType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="subcription_plan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubcriptionPlan extends BaseEntity{
	
	private String name;
	
	private String description;
	
	private double price;
	
	@Enumerated(EnumType.STRING)
	private PlanType planType;
	
	@ElementCollection
	@JoinTable(name="plan_tiffins")
	@Column(name="subcription_id")
	private List<Tiffin> tiffins = new ArrayList<Tiffin>();
	
	@ManyToMany(mappedBy = "plans")
	private List<Vendor> vendors = new ArrayList<Vendor>();
	
	@OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CustomerPlanSubcription> plans = new ArrayList<CustomerPlanSubcription>();
	
	@ManyToMany(mappedBy = "plans")
	private List<Order> orders = new ArrayList<Order>();
}
