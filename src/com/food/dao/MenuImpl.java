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
import com.food.validation.Validation;

public class MenuImpl implements MenuDao
{
	Validation valid=new Validation();
	@Override
	//insert Menu details
	public void saveMenuDetails(Menu menu) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String insert="insert into menu(id,food_id)values(?,?)";
		PreparedStatement ps1=con.prepareStatement(insert);
		boolean id=valid.idValidation(menu.getId());
		boolean foodId=valid.idValidation(menu.getFoodId());
		if(id==true) {
		ps1.setInt(1, menu.getId());
		if(foodId==true) {
		ps1.setInt(2,menu.getFoodId());
		}else
			System.out.println("Invalid Food ID");
		}else
			System.out.println("Invalid ID");
		int executeUpdate2 = ps1.executeUpdate();
		System.out.println(executeUpdate2);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Food ID");
		int fodId1=sc.nextInt();	
		String find="select unit_price from food_item where id=?";
		PreparedStatement ps=con.prepareStatement(find);
		ps.setInt(1, fodId1);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int price=rs.getInt(1);
			System.out.println(price);
			String update="update menu set price=? where food_id=?";
			PreparedStatement ps11=con.prepareStatement(update);
			ps.setInt(1, price);
			ps.setInt(2, fodId1);
			int executeUpdate = ps11.executeUpdate();
			System.out.println(executeUpdate);
		}
	
		
	}
//display the list of menuList
	@Override
	public List<Menu> menuList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="select id,price,food_id from menu";
		PreparedStatement ps=con.prepareStatement(s);
		ResultSet rs=ps.executeQuery();
		ArrayList menu=new ArrayList<>();
		while(rs.next())
		{
			int id=rs.getInt(1);
			int foodId=rs.getInt(2);
			Menu obj=new Menu();
			obj.setId(id);
			obj.setFoodId(foodId);
			menu.add(obj);
			
		}
		
		return menu;
	}
	@Override
	//delete the menu details
	public int deleteMenuDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("If you want to Know the Id is There \n Please Enter the Id");
		int id=sc.nextInt();
		String find="select id from menu where id=?";
		PreparedStatement ps=con.prepareStatement(find);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			System.out.println("The id is there :"+rs.getInt(1));
		System.out.println("Do you want to delete Menu Details: \n Please Enter the Menu Id:");
		int menuId=sc.nextInt();
		String delete="delete from menu where id=?";
		PreparedStatement ps1=con.prepareStatement(delete);
		ps1.setInt(1, menuId);
		int executeUpdate = ps1.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}

}
