package com.food.model;

public class OrderItem {
	private int id;
	private int foodId;
	private int quantity;
	private int unitPrice;
	public OrderItem()
	{
		
	}
	public OrderItem(int id,int foodId,int quantity,int unitPrice)
	{
	this.id=id;
	this.foodId=foodId;
	this.quantity=quantity;
	this.unitPrice=unitPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", foodId=" + foodId + ", quantity=" + quantity + ", unitPrice=" + unitPrice
				+ ", getId()=" + getId() + ", getFoodId()=" + getFoodId() + ", getQuantity()=" + getQuantity()
				+ ", getUnitPrice()=" + getUnitPrice() + "]";
	}
	

}
