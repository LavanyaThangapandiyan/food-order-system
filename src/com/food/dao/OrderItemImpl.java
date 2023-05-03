package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.food.model.OrderItem;
import com.food.util.ConnectionUtil;

public class OrderItemImpl implements OrderItemDao {

	@Override
	public void saveOrderItemDetails(OrderItem orit) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="insert into order_item (order_id,food_id)values(?,?)";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setInt(1, orit.getId());
		ps.setInt(2,orit.getFoodId());
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Food ID");	
		int foodId=sc.nextInt();
		String s1="select unit_price from food_item where id='"+foodId+"'";
		PreparedStatement ps1=con.prepareStatement(s1);
		ResultSet rs=ps1.executeQuery();
		while(rs.next())
		{
			int price=rs.getInt(1);
			String s3="update order_item set unit_price='"+price+"' where food_id='"+foodId+"' ";
			PreparedStatement ps3=con.prepareStatement(s3);
			int executeUpdate2 = ps3.executeUpdate();
			System.out.println(executeUpdate2);
			System.out.println("Enter Order ID");
			int orderId=sc.nextInt();
			String s4="select quantity from orderr where id='"+orderId+"'";
			PreparedStatement ps4=con.prepareStatement(s4);
			ResultSet rs4=ps4.executeQuery();
			while(rs4.next())
			{
				int quantity=rs4.getInt(1);
				String s2="update order_item set quantity='"+quantity+"' where food_id='"+foodId+"'";
				PreparedStatement ps2=con.prepareStatement(s2);
				int executeUpdate22 = ps2.executeUpdate();
				System.out.println(executeUpdate22);
		}
		
			
		}	
	}

	@Override
	public List<OrderItem> orderItemList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="select order_id,food_id,quantity,unit_price from order_item";
		PreparedStatement ps=con.prepareStatement(s);
		ResultSet rs=ps.executeQuery();
		ArrayList list=new ArrayList<>();
		while(rs.next())
		{
			int orderId=rs.getInt(1);
			int foodId=rs.getInt(2);
			int quantity=rs.getInt(3);
			int unitPrice=rs.getInt(4);
			OrderItem or=new OrderItem();
			or.setId(orderId);
			or.setFoodId(foodId);
			or.setQuantity(quantity);
			or.setUnitPrice(unitPrice);
			list.add(or);
		}
		
		return list;
	}

	@Override
	public int deleteOrderItemDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println(" if you want delete order item \n Enter food id");
		int orderId=sc.nextInt();
		String s="delete from order_item where food_id='"+orderId+"'";
		PreparedStatement ps=con.prepareStatement(s);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}


}
