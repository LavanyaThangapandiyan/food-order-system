package com.food.model;

public class FoodItem
{
	private int id;
	private String name;
	private int quantity;
	private int unitPrice;
	private String itemCategory;
	public FoodItem()
	{
		
	}
	public FoodItem(int id,String name,int quantity,int unitPrice,String itemCategory)
	{
		this.id=id;
		this.name=name;
		this.quantity=quantity;
		this.unitPrice=unitPrice;
		this.itemCategory=itemCategory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	@Override
	public String toString() {
		return "FoodItem [id=" + id + ", name=" + name + ", quantity=" + quantity + ", unitPrice=" + unitPrice
				+ ", itemCategory=" + itemCategory + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getQuantity()=" + getQuantity() + ", getUnitPrice()=" + getUnitPrice() + ", getItemCategory()="
				+ getItemCategory() + "]";
	}
	
	

}
