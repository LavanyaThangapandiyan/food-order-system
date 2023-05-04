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
	public void saveFoodItem(FoodItem food) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String insert="insert into food_item(id,name,quantity,unit_price,category)values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(insert);
		boolean id=valid.idValidation(foodit.getId());
		boolean name=valid.nameValidation(foodit.getName());
		boolean quantity=valid.numberValidation(foodit.getQuantity());
		boolean unitPrice=valid.numberValidation(foodit.getUnitPrice());
		boolean category=valid.nameValidation(foodit.getItemCategory());
		if(id) {
		ps.setInt(1,food.getId());
		if(name) {
		ps.setString(2, food.getName());
		if(quantity) {
		ps.setInt(3, food.getQuantity());
		if(unitPrice) {
		ps.setInt(4, food.getUnitPrice());
		if(category) {
		ps.setString(5,food.getItemCategory());
		}else
			System.out.println("Invalid category");
		}else
			System.out.println("invalid unit Price");
		}else
			System.out.println("Invalid Quantity");
		}else
			System.out.println("Invalid Food Name");
		}else
			System.out.println("Invalid Food Id");
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		
	}
//Display Food Item list
	@Override
	public List<FoodItem> foodItemList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String foodItemList="select id,name,quantity,unit_price,category from food_item ";
		PreparedStatement ps=con.prepareStatement(foodItemList);
		ResultSet rs=ps.executeQuery();
		ArrayList<FoodItem> foodItem=new ArrayList<>();
		while(rs.next())
		{
		int id=rs.getInt(1);
		String name=rs.getString(2);
		int quantity=rs.getInt(3);
		int unitPrice=rs.getInt(4);
		String itemCategory=rs.getString(5);
		FoodItem fd=new FoodItem();
		fd.setId(id);
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
		System.out.println("If you want to know The id is there \n Enter the Id");
		int id=sc.nextInt();
		String find="select id from food_item where id=?";
		PreparedStatement ps=con.prepareStatement(find);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			System.out.println("the id id there:"+rs.getInt(1));
		System.out.println("Do you want to delete foodItem \n Enter Food ID");
		int foodId=sc.nextInt();
		String delete="delete from food_item where id=?";
		PreparedStatement ps1=con.prepareStatement(delete);
		ps.setInt(1, foodId);
		int executeUpdate = ps1.executeUpdate();
		return executeUpdate;
	}
//Update food name by using Id
	@Override
	public void updateFoodName(int foodId, String foodName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String update="update food_item set name=? where id=?";
		PreparedStatement ps=con.prepareStatement(update);
		boolean name=valid.nameValidation(foodit.getName());
		if(name==true)
		ps.setInt(1, foodId);
		ps.setString(1, foodName);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);	
	}
//Update food Category by using Id
	@Override
	public void updateFoodCategory(int foodId1, String foodCategory) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String update="update food_item set Category=? where id=?";
		PreparedStatement ps=con.prepareStatement(update);
		boolean category=valid.nameValidation(foodit.getItemCategory());
		if(category==true)
		ps.setInt(1, foodId1);
		ps.setString(2, foodCategory);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);	
		
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
