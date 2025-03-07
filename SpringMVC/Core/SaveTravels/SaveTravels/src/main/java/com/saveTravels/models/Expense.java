package com.saveTravels.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "expenses")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 1, max = 200, message = "Name must not be blank")
	private String name;

	@NotNull
	@Size(min = 1, max = 200, message = "Vendor must not be blank")
	private String vendor;

	@NotNull(message = "Amount must not be blank")
	@Min(value = 0, message = "Amount must be greater than zero")
	private Double amount;

	@NotNull
	@Size(min = 1, max = 200, message = "Description must not be blank")
	private String description;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Expense() {}
	
	public Expense(String name, String vendor, Double amount, String description) {
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
