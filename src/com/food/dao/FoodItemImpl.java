package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.food.model.FoodItem;
import com.food.util.ConnectionUtil;
import com.food.validation.Validation;

public class FoodItemImpl implements FoodItemDao{
   FoodItem foodit=new FoodItem();
   Validation valid=new Validation();
   
   //Insert food Item details
	@Override
	public void saveFoodItem() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter food Name");
    	String name=sc.next();
    	System.out.println("Enter quantity");
    	int quantity=sc.nextInt(); 		
    	System.out.println("Enter unit Price");
    	int unitPrice=sc.nextInt();
    	System.out.println("Enter food category");		
    	String itemCategory=sc.next();			
    	FoodItem foodit =new FoodItem();
    	foodit.setName(name);
        foodit.setQuantity(quantity);
    	foodit.setUnitPrice(unitPrice);
    	foodit.setItemCategory(itemCategory);
		String insert="insert into food_item(name,quantity,unit_price,category)values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(insert);
		boolean name1=valid.nameValidation(foodit.getName());
		boolean quantity1=valid.numberValidation(foodit.getQuantity());
		boolean unitPrice1=valid.numberValidation(foodit.getUnitPrice());
		boolean category=valid.nameValidation(foodit.getItemCategory());
		if( name1==true&&quantity1==true&&unitPrice1==true&&category==true) 
		{
		ps.setString(1, foodit.getName());
		ps.setInt(2, foodit.getQuantity());
		ps.setInt(3, foodit.getUnitPrice());
		ps.setString(4,foodit.getItemCategory());
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		}else
			System.out.println("Invalid Input");
        
	}
//Display Food Item list
	@Override
	public List<FoodItem> foodItemList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Connection con=ConnectionUtil.getConnection();
		String foodItemList="select id,name,quantity,unit_price,category from food_item ";
		PreparedStatement ps=con.prepareStatement(foodItemList);
		ResultSet rs=ps.executeQuery();
		ArrayList<FoodItem> foodItem=new ArrayList<>();
		while(rs.next())
		{	
		int id1=rs.getInt(1);
		String name=rs.getString(2);
		int quantity=rs.getInt(3);
		int unitPrice=rs.getInt(4);
		String itemCategory=rs.getString(5);
		FoodItem fd=new FoodItem();
		fd.setId(id1);
		fd.setName(name);
		fd.setQuantity(quantity);
		fd.setUnitPrice(unitPrice);
		fd.setItemCategory(itemCategory);
		foodItem.add(fd);
		}
		return foodItem;
		
	}
//delete food item by using ID
	@Override
	public int deleteFoodItem() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Connection con=ConnectionUtil.getConnection();
		System.out.println("Do you want to delete foodItem \n Enter Food ID");
		int foodId=sc.nextInt();
		String delete="delete from food_item where id=?";
		PreparedStatement ps=con.prepareStatement(delete);
		ps.setInt(1, foodId);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}
//Update food name by using Id
	@Override
	public int updateFoodName(int foodId, String foodName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String update="update food_item set name=? where id=?";
		PreparedStatement ps=con.prepareStatement(update);
		ps.setString(1, foodName);
		ps.setInt(2, foodId);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}
//Update food Category by using Id
	@Override
	public int updateFoodCategory(int foodId1, String foodCategory) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String update="update food_item set Category=? where id=?";
		PreparedStatement ps=con.prepareStatement(update);
		ps.setString(1, foodCategory);
		ps.setInt(2, foodId1);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
		
	}
//find food Category by using id
	@Override
	public void findFoodCategory(int foodId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String find="select name,category from food_item where id=?";
		PreparedStatement ps=con.prepareStatement(find);
		ps.setInt(1, foodId);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			System.out.println(rs.getString(1)+"\t"+rs.getString(2));
		
	}
	

}
