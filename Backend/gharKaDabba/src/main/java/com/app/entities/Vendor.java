package com.app.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="vendors")
@Getter
@Setter
@ToString
public class Vendor extends BaseEntity {
	
	private boolean isVerified;
	
	@Embedded
	private Address deliveryAddress;
	
	@OneToOne
	@JoinColumn(name="user_id")
	@MapsId
	private UserEntity userEntity;
	

	
	
	
}
