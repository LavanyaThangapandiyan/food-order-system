package com.food.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.food.dao.FoodItemImpl;
import com.food.model.FoodItem;
import com.food.util.ConnectionUtil;

public class TestFoodItem {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//ConnectionUtil.getConnection();
		Scanner sc=new Scanner(System.in);
		FoodItemImpl food=new FoodItemImpl();
		
		//-->insert
				/*int id=2004;
				String name="Chocolatebrownie";
				int quantity=1;
				int unitPrice=100;
				String itemCategory="dessert";
				FoodItem foodit =new FoodItem();
				foodit.setId(id);
				foodit.setName(name);
				foodit.setQuantity(quantity);
				foodit.setUnitPrice(unitPrice);
				foodit.setItemCategory(itemCategory);
				food.saveFoodItem(foodit);
		
		//==>update
		/*System.out.println("Do you want Update food name \nEnter Food Id Update");
	    int foodId=sc.nextInt();
	    System.out.println("Enter New Food Name");
	    String name=sc.next();
			food.updateFoodName(foodId, name);*/
			
			/*System.out.println("Do you want updateFoodCategory\n  Enter Food Id");
		    int foodId1=sc.nextInt();
		    System.out.println("Enter new Category");
				food.updateFoodCategory(foodId1, foodCategory);
		    
	
			
		
		//==>find
		System.out.println("Do you want find Food Category: \n please enter food id");
		int foodId=sc.nextInt();
		food.findFoodCategory(foodId);
		
		
		
		/*delete
			food.deleteFoodItem();*/
		
		
		/*List<FoodItem> foodItemList = food.foodItemList();
		System.out.println(foodItemList);*/
		
		
		


	}

}
