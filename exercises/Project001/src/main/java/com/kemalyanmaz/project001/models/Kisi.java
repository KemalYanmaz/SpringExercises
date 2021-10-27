package com.kemalyanmaz.project001.models;

import java.math.BigDecimal;

public class Kisi {
	private String firstName;
	private String lastName;
	private BigDecimal budget;
	
	public Kisi(){
		
	}
	
	public Kisi(String firstName, String lastName, BigDecimal budget) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.budget = budget;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public BigDecimal getBudget() {
		return budget;
	}
	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
	
	

}
