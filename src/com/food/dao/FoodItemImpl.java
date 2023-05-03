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

public class FoodItemImpl implements FoodItemDao{

	@Override
	public void saveFoodItem(FoodItem food) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="insert into food_item(id,name,quantity,unit_price,category)values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setInt(1,food.getId());
		ps.setString(2, food.getName());
		ps.setInt(3, food.getQuantity());
		ps.setInt(4, food.getUnitPrice());
		ps.setString(5,food.getItemCategory());
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		
	}

	@Override
	public List<FoodItem> foodItemList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="select id,name,quantity,unit_price,category from food_item ";
		PreparedStatement ps=con.prepareStatement(s);
		ResultSet rs=ps.executeQuery();
		ArrayList list=new ArrayList<>();
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
		list.add(fd);
		}
		return list;
	}

	@Override
	public int deleteFoodItem() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Do you want to delete foodItem \n Enter Food ID");
		int foodId=sc.nextInt();
		Connection con=ConnectionUtil.getConnection();
		String s="delete from food_item where id='"+foodId+"'";
		PreparedStatement ps=con.prepareStatement(s);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}

	@Override
	public void updateFoodName(int foodId, String foodName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="update food_item set name='"+foodName+"' where id='"+foodId+"'";
		PreparedStatement ps=con.prepareStatement(s);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);	
	}

	@Override
	public void updateFoodCategory(int foodId1, String foodCategory) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="update food_item set Category='"+foodCategory+"' where id='"+foodId1+"'";
		PreparedStatement ps=con.prepareStatement(s);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);	
		
	}

	@Override
	public void findFoodCategory(int foodId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="select name,category from food_item where id='"+foodId+"'";
		PreparedStatement ps=con.prepareStatement(s);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			System.out.println(rs.getString(1)+"\t"+rs.getString(2));
		
	}
	

}
