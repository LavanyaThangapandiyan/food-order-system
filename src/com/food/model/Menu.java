package com.food.model;

public class Menu {
	private int id;
	private int foodId;
	public Menu()
	{
		
	}
	public Menu(int id,int price,int foodId)
	{
	this.id=id;
	this.foodId=foodId;
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
	@Override
	public String toString() {
		return "Menu [id=" + id + ", foodId=" + foodId + ", getId()=" + getId() + ", getFoodId()=" + getFoodId() + "]";
	}
	
	
}
