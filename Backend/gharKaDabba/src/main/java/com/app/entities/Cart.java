package com.app.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="carts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends BaseEntity {

	private int totalItems;

	private double totalCartPrice;

	@CreationTimestamp
	private LocalDate createdOn;

	@UpdateTimestamp
	private LocalDate lastUpdatedOn;

	@OneToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer cartOwner;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<SubscriptionPlan> plans = new HashSet<>();

}
