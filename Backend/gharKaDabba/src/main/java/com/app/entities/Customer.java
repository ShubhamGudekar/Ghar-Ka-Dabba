package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {
	
	@OneToOne
	@JoinColumn(name="user_id")
	@MapsId 
	private UserEntity userEntity;

	@ElementCollection
	@CollectionTable(name="delivery_addresses")
	@Column(name="cust_id")
	private List<Address> deliveryAddress = new ArrayList<Address>();
	
	
	@OneToOne(mappedBy = "customer")
	private Order order;
}
