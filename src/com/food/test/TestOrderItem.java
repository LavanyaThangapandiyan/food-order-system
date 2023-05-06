package com.food.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.food.dao.OrderItemImpl;
import com.food.model.OrderItem;
import com.food.util.ConnectionUtil;
import com.login.details.Login;

public class TestOrderItem {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//ConnectionUtil.getConnection();
		Scanner sc=new Scanner(System.in);
		OrderItemImpl or=new OrderItemImpl();
		Login login=new Login();
		System.out.println("Enter Admin Id");
		int id=sc.nextInt();
		boolean adminLogin=login.adminLoginDetails(id);
		if(adminLogin==true)
		{
			System.out.println("1. Insert Order Item \n 2.Show Order Item list \n 3. Delete Order Item \n ");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:
			{
				System.out.println("Enter Order Id");
				int orderId=sc.nextInt();
				System.out.println("Enter Food ID");
				int foodId=sc.nextInt();
				OrderItem ord=new OrderItem();
				ord.setId(orderId);
				ord.setFoodId(foodId);
		        or.saveOrderItemDetails(ord);
		        break;
			}
			case 2:
			{
				List<OrderItem> orderItemList = or.orderItemList();
				System.out.println(orderItemList);
				break;
			}
			case 3:
			{
				or.deleteOrderItemDetails();
			}
			}}
			else
			System.out.println("Invalid Id");
		}
		
		
		

		
}
