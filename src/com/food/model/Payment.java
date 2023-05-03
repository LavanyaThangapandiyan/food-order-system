package com.food.model;

public class Payment {
	private int id;
	private int customerId;
	private int orderId;
	private String paymentDate;
	private double amount;
	private String paymentType;
	public Payment()
	{
		
	}
	public Payment(int id,int customerId,int orderId,String paymentDate,double amount,String paymentType)
	{
		this.id=id;
		this.customerId=customerId;
		this.orderId=orderId;
		this.paymentDate=paymentDate;
		this.amount=amount;
		this.paymentType=paymentType;	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", customerId=" + customerId + ", orderId=" + orderId + ", paymentDate="
				+ paymentDate + ", amount=" + amount + ", paymentType=" + paymentType + ", getId()=" + getId()
				+ ", getCustomerId()=" + getCustomerId() + ", getOrderId()=" + getOrderId() + ", getPaymentDate()="
				+ getPaymentDate() + ", getAmount()=" + getAmount() + ", getPaymentType()=" + getPaymentType() + "]";
	}
	

}
