package com.food.model;

public class Customer {
	
	private int id;
	private String email;
	private String phoneNo;
	private String firstName;
	private String lastName;
	private int paymentId;
	private int foodId;
	public Customer()
	{
		
	}
	public Customer(int customerId,String email,String phoneNo,String firstName,String lastName,int paymentId,int foodId)
	{
		this.id=customerId;
		this.email=email;
		this.phoneNo=phoneNo;
		this.firstName=firstName;
		this.lastName=lastName;
		this.paymentId=paymentId;
		this.foodId=foodId;
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", phoneNo=" + phoneNo + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", paymentId=" + paymentId + ", foodId=" + foodId + ", getId()=" + getId()
				+ ", getEmail()=" + getEmail() + ", getPhoneNo()=" + getPhoneNo() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getPaymentId()=" + getPaymentId() + ", getFoodId()="
				+ getFoodId() + "]";
	}
	
	
	

}
