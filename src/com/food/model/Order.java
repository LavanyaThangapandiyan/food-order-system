package com.food.model;

import java.util.Date;

public class Order {
	private int id;
	private String date;
	private int customerId;
	private int quantity;
	private int foodId;
	
public Order() {
	
}
public Order(int id,String date,int customerId,int quantity,int foodId )
{
	this.id=id;
	this.date=date;
	this.customerId=customerId;
	this.quantity=quantity;
	this.foodId=foodId;
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
public int getFoodId() {
	return foodId;
}
public void setFoodId(int foodId) {
	this.foodId = foodId;
}
@Override
public String toString() {
	return "Order [id=" + id + ", date=" + date + ", customerId=" + customerId + ", quantity=" + quantity + ", foodId="
			+ foodId + ", getId()=" + getId() + ", getDate()=" + getDate() + ", getCustomerId()=" + getCustomerId()
			+ ", getQuantity()=" + getQuantity() + ", getFoodId()=" + getFoodId() + "]";
}

}
