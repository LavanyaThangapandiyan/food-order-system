package com.food.dao;

import java.util.List;

public interface MenuDao 
{
	public void saveMenuDetails();
	public List menuList();
	public void updatePrice(int menuId,int price);
	public void updateStartDate(int menuId,int startDate);
	public void updateEndDate(int menuId,int endDate);
	public int deleteMenuDetails();
	

}
