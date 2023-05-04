package com.food.model;

public class Customer {
	
	private int id;
	private String email;
	private String phoneNumber;
	private String name;
	public Customer()
	{
		
	}
	public Customer(int id,String email,String phoneNo,String name)
	{
		this.id=id;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", phoneNumber=" + phoneNumber + ", name=" + name+ "]";
	}
	
	
}
