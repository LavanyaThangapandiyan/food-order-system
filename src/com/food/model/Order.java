package com.food.model;

public class Order {
	private int id;
	private String date;
	private int customerId;
	private int quantity;
	private String pickupDate;
	public Order()
	{
		
	}
	public Order(int id,String date,int customerId,int quantity,String pickupDate)
	{
		this.id=id;
		this.date=date;
		this.customerId=customerId;
		this.quantity=quantity;
		this.pickupDate=pickupDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", customerId=" + customerId + ", quantity=" + quantity
				+ ", pickupDate=" + pickupDate + ", getId()=" + getId() + ", getDate()=" + getDate()
				+ ", getCustomerId()=" + getCustomerId() + ", getQuantity()=" + getQuantity() + ", getPickupDate()="
				+ getPickupDate() + "]";
	}
	

}
