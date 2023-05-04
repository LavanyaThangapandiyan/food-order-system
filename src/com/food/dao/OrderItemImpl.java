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
import com.food.validation.Validation;

public class OrderItemImpl implements OrderItemDao {
Validation valid=new Validation();
	@Override
	// Insert order item details
	public void saveOrderItemDetails(OrderItem orit) throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String insert="insert into order_item (order_id,food_id)values(?,?)";
		PreparedStatement ps=con.prepareStatement(insert);
		boolean id=valid.idValidation(orit.getId());
		boolean fodId=valid.idValidation(orit.getFoodId());
		if(id==true) {
		ps.setInt(1, orit.getId());
		if(fodId==true) {
		ps.setInt(2,orit.getFoodId());
		}else
			System.out.println("Invalid food Id");
		}System.out.println("Invalid id");
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Food ID");	
		int foodId=sc.nextInt();
		String find="select unit_price from food_item where id=?";
		PreparedStatement ps1=con.prepareStatement(find);
		ps.setInt(1,foodId);
		ResultSet rs=ps1.executeQuery();
		while(rs.next())
		{
			int price=rs.getInt(1);
			String update="update order_item set unit_price=? where food_id=?";
			PreparedStatement ps3=con.prepareStatement(update);
			int executeUpdate2 = ps3.executeUpdate();
			System.out.println(executeUpdate2);
			System.out.println("Enter Order ID");
			int orderId=sc.nextInt();
			String find1="select quantity from orderr where id=?";
			PreparedStatement ps4=con.prepareStatement(find1);
			ps4.setInt(1,foodId);
			ResultSet rs4=ps4.executeQuery();
			while(rs4.next())
			{
				int quantity=rs4.getInt(1);
				String update1="update order_item set quantity=? where food_id=?";
				PreparedStatement ps2=con.prepareStatement(update1);
				ps2.setInt(1,foodId);
				ps2.setInt(2,quantity);
				int executeUpdate22 = ps2.executeUpdate();
				System.out.println(executeUpdate22);
		}
		
			
		}	
	}
//Display the list of Order Item
	@Override
	public List<OrderItem> orderItemList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String orderList="select order_id,food_id,quantity,unit_price from order_item";
		PreparedStatement ps=con.prepareStatement(orderList);
		ResultSet rs=ps.executeQuery();
		ArrayList orderItem=new ArrayList<>();
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
			orderItem.add(or);
		}
		
		return orderItem;
	}
// Delete order Item
	@Override
	public int deleteOrderItemDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("if you want to check the id is there \n Enter the id");
		int id=sc.nextInt();
		String find="select id from order_item where id=?";
		PreparedStatement ps=con.prepareStatement(find);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			System.out.println("THE ID IS THERE:"+rs.getInt(1));
		System.out.println(" if you want delete order item \n Enter food id");
		int orderId=sc.nextInt();
		String delete="delete from order_item where food_id=?";
		PreparedStatement ps1=con.prepareStatement(delete);
		ps1.setInt(1,orderId);
		int executeUpdate = ps1.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}


}
