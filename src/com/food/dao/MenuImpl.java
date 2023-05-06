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
		Scanner sc=new Scanner(System.in);
		Connection con=ConnectionUtil.getConnection();
		String insert="insert into menu(food_id)values(?)";
		PreparedStatement ps111=con.prepareStatement(insert);
		boolean foodId=valid.idValidation(menu.getFoodId());
		if(foodId==true) {
		ps111.setInt(1,menu.getFoodId());
		}else
			System.out.println("Invalid Food ID");
		int executeUpdate2 = ps111.executeUpdate();
		System.out.println(executeUpdate2);
		System.out.println("Enter Food ID");
		int fodId1=sc.nextInt();	
		String find1="select unit_price from food_item where id=?";
		PreparedStatement ps=con.prepareStatement(find1);
		ps.setInt(1, fodId1);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int price=rs.getInt(1);
			System.out.println(price);
			String update="update menu set price=? where food_id=?";
			PreparedStatement ps11=con.prepareStatement(update);
			ps11.setInt(1, price);
			ps11.setInt(2, fodId1);
			int executeUpdate = ps11.executeUpdate();
			System.out.println(executeUpdate);
		}
		
	}
//display the list of menuList
	@Override
	public List<Menu> menuList() throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		ArrayList<Menu> menu1=new ArrayList<>();
		String menuList="select id,food_id from menu";
	    PreparedStatement ps=con.prepareStatement(menuList);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int cusid=rs.getInt(1);
			int foodId=rs.getInt(2);
			 Menu obj=new Menu();
			obj.setId(cusid);
			obj.setFoodId(foodId);
		    menu1.add(obj);	
		}
		return menu1;
		
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
