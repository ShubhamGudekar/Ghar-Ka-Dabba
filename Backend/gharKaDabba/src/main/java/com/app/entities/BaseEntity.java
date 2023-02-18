package com.app.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

	// Common in all Entities
	@Id
	// Auto_Increement Property in MySQL
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Adding support for Optimistic Locking
	@Version
	private int version;

}
