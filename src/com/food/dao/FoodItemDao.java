package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import com.food.model.FoodItem;

public interface FoodItemDao
{
	public void saveFoodItem(FoodItem food) throws ClassNotFoundException, SQLException;
	public List<FoodItem> foodItemList() throws ClassNotFoundException, SQLException;
	public int deleteFoodItem() throws ClassNotFoundException, SQLException;
	public void updateFoodName(int foodId,String foodName) throws ClassNotFoundException, SQLException;
	public void updateFoodCategory(int foodId1,String foodCategory) throws ClassNotFoundException, SQLException;
	public void findFoodCategory(int foodId) throws ClassNotFoundException, SQLException;

}
