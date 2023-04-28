package com.food.model;

public class Menu {
	private int id;
	private int price;
	private String startDate;
	private String endDate;
	private int foodId;
	public Menu()
	{
		
	}
	public Menu(int id,int price,String startDate,String endDate,int foodId)
	{
	this.id=id;
	this.price=price;
	this.startDate=startDate;
	this.endDate=endDate;
	this.foodId=foodId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", price=" + price + ", startDate=" + startDate + ", endDate=" + endDate + ", foodId="
				+ foodId + ", getId()=" + getId() + ", getPrice()=" + getPrice() + ", getStartDate()=" + getStartDate()
				+ ", getEndDate()=" + getEndDate() + ", getFoodId()=" + getFoodId() + "]";
	}
	

}
