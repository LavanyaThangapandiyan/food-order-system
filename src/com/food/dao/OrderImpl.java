package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.food.model.Customer;
import com.food.model.Order;
import com.food.model.OrderItem;
import com.food.util.ConnectionUtil;

public class OrderImpl implements OrderDao {

	@Override
	public void saveOrderDetails(Order or) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="insert into order_food(id,order_date,customer_id,quantity,pickup_date)values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setInt(1, or.getId());
		ps.setString(2, or.getDate());
		ps.setInt(3,or.getCustomerId());
		ps.setInt(4, or.getCustomerId());
		ps.setString(5, or.getPickupDate());
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		
	}

	@Override
	public List<Order> orderList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Connection con=ConnectionUtil.getConnection();
		 String s="select id,order_date,customer_id,quantity,pickup_date from order_food";
			PreparedStatement ps=con.prepareStatement(s);
			ResultSet rs=ps.executeQuery();
			ArrayList list=new ArrayList<>();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String date=rs.getString(2);
				int customerId=rs.getInt(3);
				int quantity=rs.getInt(4);
				String pickupDate=rs.getString(5);
				Order or=new Order();
				or.setId(id);
				or.setDate(date);
				or.setCustomerId(customerId);
				or.setQuantity(quantity);
				or.setPickupDate(pickupDate);
				list.add(or);
				
			}
		    	
		return list;
	}

	@Override
	public int deleteOrderDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Do you want Delete the Order Details: \n Please Enter the Order ID:");
		int orderId=sc.nextInt();
		Connection con=ConnectionUtil.getConnection();
		String s="delete from order_food where id='"+orderId+"'";
		PreparedStatement ps=con.prepareStatement(s);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}

	@Override
	public int updateOrderQuantity(int orderId, int quantity) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="update order_food set quantity='"+quantity+"' where id='"+orderId+"'";
		PreparedStatement ps=con.prepareStatement(s);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}

	@Override
	public void findOrderQuantity(int orderId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select quantity from order_food where id='"+orderId+"'");
		while(rs.next())
			System.out.println(rs.getString(1));
	}

	@Override
	public void findOrderPickupDate(int orderId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select pickup_date from order_food where id='"+orderId+"'");
		while(rs.next())
			System.out.println(rs.getString(1));
		
	}

	
}