package com.food.test;

import java.util.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.food.dao.OrderImpl;
import com.food.model.Order;
import com.food.util.ConnectionUtil;

public class TestOrder {
	public static void main(String[]args) throws ClassNotFoundException, SQLException
	{
		//ConnectionUtil.getConnection();
		Scanner sc=new Scanner(System.in);
		OrderImpl order=new OrderImpl();
		//List<Order> orderList = order.orderList();
		//System.out.println(orderList);
		/*
		System.out.println("Do you want Delete the Order Details: \n Please Enter the Order ID:");
		int orderId=sc.nextInt();
		order.deleteOrderDetails();*/
		//---->insert */
				System.out.println("Enter Order ID:");
			    int id=sc.nextInt();
			    System.out.println("Enter Customer Id");
			    int customerId=sc.nextInt();
			    System.out.println("Enter Quantity");
			    int quantity=sc.nextInt();
			    System.out.println("Enter Food Id");
			     int foodId=sc.nextInt();   
			        Order or=new Order();
			       
			        	or.setId(id);
			        or.setCustomerId(customerId);
			        or.setQuantity(quantity);
			        	or.setFoodId(foodId);
			        order.saveOrderDetails(or);
			
		/*System.out.println("Do you Want Find Order Quantity --> Enter 1\n Do you want Find Order Pickup Date -->Enter 2 ");
		int number=sc.nextInt();
		if(number==1)
		{
		System.out.println("Please Enter Yout Order ID");
		int orderId=sc.nextInt();
		if(orderId>0)
			order.findOrderQuantity(orderId);
		else
			System.out.println("Invalid Order Id");
		}
		else if(number==2)
		{
			System.out.println("Please Enter order ID");
			int orderId=sc.nextInt();
			if(orderId>0)
				order.findOrderDate(orderId);
				
		}*/
		
		 //==>update
       /* System.out.println("Do you want Update the Order Quantity \n Please Enter Order Id");
        int orderId=sc.nextInt();
        System.out.println("Enter your New Quantity:");
        int quantity=sc.nextInt();
        order.updateOrderQuantity(orderId, quantity);*/
       
		
				
		
		
		
			
		
	}

}
