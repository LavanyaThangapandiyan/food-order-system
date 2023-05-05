package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.food.model.Customer;
import com.food.model.Order;
import com.food.model.OrderItem;
import com.food.util.ConnectionUtil;
import com.food.validation.Validation;

public class OrderImpl implements OrderDao {
Validation valid=new Validation();
	@Override
	public void saveOrderDetails(Order or) throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String insert="insert into orderr(id,date,customer_id,quantity,food_id)values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(insert);
		boolean id=valid.idValidation(or.getId());
		boolean customerId=valid.idValidation(or.getCustomerId());
		boolean quantity=valid.numberValidation(or.getFoodId());
		boolean foodId=valid.idValidation(or.getFoodId());
		Date date=new Date();
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		if(id==true) {
		ps.setInt(1, or.getId());
		ps.setDate(2, sqldate);
		if(customerId==true) {
		ps.setInt(3,or.getCustomerId());
		if(quantity==true) {
		ps.setInt(4, or.getQuantity());
		if(foodId==true) {
		ps.setInt(5, or.getFoodId());
		}else
			System.out.println("Invalid Food Id");
		}else
			System.out.println("Invalid Quantity");
		}else
			System.out.println("Invalid Customer Id");
		}else
			System.out.println("Invalid Id");
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		
	}

	@Override
	public List<Order> orderList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Connection con=ConnectionUtil.getConnection();
		 String orderList="select id,date,customer_id,quantity,food_id from orderr";
			PreparedStatement ps=con.prepareStatement(orderList);
			ResultSet rs=ps.executeQuery();
			ArrayList order=new ArrayList<>();
			while(rs.next())
			{
				int id=rs.getInt(1);
				Date date=rs.getDate(2);
				int customerId=rs.getInt(3);
				int quantity=rs.getInt(4);
				int foodId=rs.getInt(5);
				Order or=new Order();
				or.setId(id);
				or.setDate((java.sql.Date) date);
				or.setCustomerId(customerId);
				or.setQuantity(quantity);
				or.setFoodId(foodId);
				order.add(or);		
			}    	
		return order;
	}

	@Override
	public int deleteOrderDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Connection con=ConnectionUtil.getConnection();
		System.out.println("if you want to check the id is there \n please enter the id");
		int id=sc.nextInt();
		String find="select id from orderr where id=?";
		PreparedStatement ps=con.prepareStatement(find);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			System.out.println("the id is there :" +rs.getInt(1));
		
		System.out.println("Enter Order ID");
		int orderId=sc.nextInt();
		String delete="delete from orderr where id=?";
		PreparedStatement ps1=con.prepareStatement(delete);
		ps1.setInt(1, orderId);
		int executeUpdate = ps1.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}

	@Override
	public int updateOrderQuantity(int orderId, int quantity) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String update="update orderr set quantity=? where id=?";
		PreparedStatement ps=con.prepareStatement(update);
		ps.setInt(1, orderId);
		ps.setInt(2, quantity);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}

	@Override
	public void findOrderQuantity(int orderId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String find="select quantity from orderr where id=?";
		PreparedStatement ps=con.prepareStatement(find);
		ps.setInt(1,orderId);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			System.out.println(rs.getString(1));
	}

	@Override
	public void findOrderDate(int orderId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String find="select date from orderr where id=?";
		PreparedStatement ps=con.prepareStatement(find);
		ps.setInt(1,orderId);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			System.out.println(rs.getString(1));
		
	}

	
}
