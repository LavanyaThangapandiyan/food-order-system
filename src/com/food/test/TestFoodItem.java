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
				if(id>=2000) 
				{
				foodit.setId(id);
				Pattern p=Pattern.compile("[a-zA-Z]+");
				Matcher m=p.matcher(name);
				boolean nm=m.matches();
				if(nm) 
				{
				foodit.setName(name);
				if(quantity>0) 
				{
				foodit.setQuantity(quantity);
				if(unitPrice>0)
				{
				foodit.setUnitPrice(unitPrice);
				if(itemCategory!="0") 
				{
				foodit.setItemCategory(itemCategory);
				food.saveFoodItem(foodit);
				}
				else
					System.out.println("Invalid ItemCategory");
				}
				else
					System.out.println("Invalid unit price");
				}
				else
					System.out.println("Invalid Quantity");
				}
				else
					System.out.println("Invalid Food name");
				}*/
		
		//==>update
		/*System.out.println("Do you want Update food name \nEnter Food Id Update");
	    int foodId=sc.nextInt();
	    System.out.println("Enter New Food Name");
	    String name=sc.next();
	    Pattern p=Pattern.compile("[a-zA-Z]+");
		Matcher m=p.matcher(name);
		boolean nm=m.matches();
		if(nm)
			food.updateFoodName(foodId, name); 
		else
			System.out.println("Invalid Name \n  not Update Food name...");*/
			
			System.out.println("Do you want updateFoodCategory\n  Enter Food Id");
		    int foodId1=sc.nextInt();
		    System.out.println("Enter new Category");
		    String foodCategory=sc.next();
		    Pattern p1=Pattern.compile("[a-zA-Z]+");
			Matcher m1=p1.matcher(foodCategory);
			boolean nm1=m1.matches();
			if(nm1)
				food.updateFoodCategory(foodId1, foodCategory);
			else
				System.out.println("Invalid Category \n not Update Category");
		    
	
			
		
		//==>find
		/*System.out.println("Do you want find Food Category: \n please enter food id");
		int foodId=sc.nextInt();
		food.findFoodCategory(foodId);*/
		
		
		
		//food.deleteFoodItem();
		
		
		/*List<FoodItem> foodItemList = food.foodItemList();
		System.out.println(foodItemList);*/
		
		
		


	}

}
