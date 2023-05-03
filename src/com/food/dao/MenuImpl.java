package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.food.model.Menu;
import com.food.util.ConnectionUtil;

public class MenuImpl implements MenuDao
{

	@Override
	public void saveMenuDetails(Menu menu) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s11="insert into menu(id,food_id)values(?,?)";
		PreparedStatement ps1=con.prepareStatement(s11);
		ps1.setInt(1, menu.getId());
		ps1.setInt(2,menu.getFoodId());
		int executeUpdate2 = ps1.executeUpdate();
		System.out.println(executeUpdate2);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Food ID");
		int foodId=sc.nextInt();	
		String s="select unit_price from food_item where id='"+foodId+"'";
		PreparedStatement ps=con.prepareStatement(s);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int price=rs.getInt(1);
			System.out.println(price);
			String s1="update menu set price='"+price+"'where food_id='"+foodId+"'";
			PreparedStatement ps11=con.prepareStatement(s1);
			int executeUpdate = ps11.executeUpdate();
			System.out.println(executeUpdate);
		}
	
		
	}

	@Override
	public List<Menu> menuList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="select id,price,food_id from menu";
		PreparedStatement ps=con.prepareStatement(s);
		ResultSet rs=ps.executeQuery();
		ArrayList list=new ArrayList<>();
		while(rs.next())
		{
			int id=rs.getInt(1);
			int foodId=rs.getInt(2);
			Menu obj=new Menu();
			obj.setId(id);
			obj.setFoodId(foodId);
			list.add(obj);
			
		}
		
		return list;
	}
	@Override
	public int deleteMenuDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Do you want to delete Menu Details: \n Please Enter the Menu Id:");
		int menuId=sc.nextInt();
		Connection con=ConnectionUtil.getConnection();
		String s="delete from menu where id='"+menuId+"'";
		PreparedStatement ps=con.prepareStatement(s);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}

}
