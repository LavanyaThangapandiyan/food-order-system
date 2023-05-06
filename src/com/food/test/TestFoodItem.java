package com.food.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.food.dao.FoodItemImpl;
import com.food.model.FoodItem;
import com.food.util.ConnectionUtil;
import com.login.details.Login;

public class TestFoodItem {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//ConnectionUtil.getConnection();
		Login login=new Login();
		Scanner sc=new Scanner(System.in);
		FoodItemImpl food=new FoodItemImpl();
		FoodItem fd=new FoodItem();
		System.out.println("Admin Login ==>1 \n Customer Login ==>2");
		int number=sc.nextInt();
		if(number==1)
		{
		System.out.println("enter your Admin id:");
		int adminId = sc.nextInt();
		boolean adminLogin = login.adminLoginDetails(adminId);
		if(adminLogin== true) 
		 {
			System.out.println("Save food Item ==>1.\n Update food Name==>2 \n Update food Category ==>3 \n Find Food Category==>4 \n Show food item==>5 \n Delete food Item==>6");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
			{
				food.saveFoodItem();
				break;
			}
			case 2:
			{
				System.out.println("Do you want Update food name \nEnter Food Id Update");
			    int foodId=sc.nextInt();
			    System.out.println("Enter New Food Name");
			    String name=sc.next();
					food.updateFoodName(foodId, name);
					break;
			}
			case 3:
			{
				System.out.println("Do you want updateFoodCategory\n  Enter Food Id");
			    int foodId1=sc.nextInt();
			    System.out.println("Enter new Category");
			    String foodCategory=sc.next();
					food.updateFoodCategory(foodId1, foodCategory);
					break;
			}
			case 4:
			{
				System.out.println("Do you want find Food Category: \n please enter food id");
				int foodId=sc.nextInt();
				food.findFoodCategory(foodId);
				break;
			}
			case 5:
			{
				List<FoodItem> foodItemList = food.foodItemList();
				System.out.println(foodItemList);
				break;
			}
			case 6:
			{
				food.deleteFoodItem();	
				break;
			}
			}
			
		 }else
		    	System.out.println("Invalid Id");
		}
		else if(number==2)
		{
			System.out.println("enter your Customer id:");
			int customerId = sc.nextInt();
			boolean customerLogin = login.customerLoginDetails(customerId);
			if(customerLogin== true) 
			 {
				List<FoodItem> foodItemList = food.foodItemList();
				System.out.println(foodItemList);
			 }
			else
				System.out.println("Invalid Id");
			
		}
		
		
		
		
		
		
		


	}

}
