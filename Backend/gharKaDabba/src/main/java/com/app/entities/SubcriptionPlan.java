package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
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
	
	@Enumerated(EnumType.STRING)
	private PlanType planType;
	
	@ElementCollection
	@JoinTable(name="plan_tiffins")
	@Column(name="subcription_id")
	private List<Tiffin> tiffins = new ArrayList<Tiffin>();
	
}
