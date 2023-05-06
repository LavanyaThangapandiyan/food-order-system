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
import com.login.details.Login;

public class TestOrder {
	public static void main(String[]args) throws ClassNotFoundException, SQLException
	{
		//ConnectionUtil.getConnection();
		Login login=new Login();
		Scanner sc=new Scanner(System.in);
		OrderImpl order=new OrderImpl();
		
		System.out.println("Customer login ==>1 \n Admin Login==>2.");
		int choice=sc.nextInt();
		if(choice==1)
		{
			System.out.println("Enter Customer ID");
			int csid=sc.nextInt();
			boolean idlogin=login.customerLoginDetails(csid);
		if(idlogin==true)
		{
			System.out.println(" choose option \n 1.Save order \n 2.Update Order Quantity \n 3.Delete Order \n 4.Find order Quantity \n 5. Find order Date");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:
			{
			    System.out.println("Enter Customer Id");
			    int customerId=sc.nextInt();
			    System.out.println("Enter Quantity");
			    int quantity=sc.nextInt();
			    System.out.println("Enter Food Id");
			     int foodId=sc.nextInt();   
			        Order or=new Order();
			        or.setCustomerId(customerId);
			        or.setQuantity(quantity);
			        or.setFoodId(foodId);
			        order.saveOrderDetails(or);
			        break;
			}
			case 2:
			{
				System.out.println("Do you want Update the Order Quantity \n Please Enter Order Id");
		        int orderId=sc.nextInt();
		        System.out.println("Enter your New Quantity:");
		        int quantity=sc.nextInt();
		        order.updateOrderQuantity(orderId, quantity);
		        break;
			}
			case 3:
			{
				order.deleteOrderDetails();
				break;
			}
			case 4:
			{
				System.out.println("Please Enter Yout Order ID");
				int orderId=sc.nextInt();
				if(orderId>0)
					order.findOrderQuantity(orderId);
				else
					System.out.println("Invalid Order Id");
				break;
			}
			case 5:
			{
				System.out.println("Please Enter order ID");
				int orderId=sc.nextInt();
				if(orderId>0)
					order.findOrderDate(orderId);
				break;
			}	
			}}
			else
				System.out.println("Invalid Id");
			}
		else if(choice==2)
		{
			System.out.println("Enter Admin ID");
			int adid=sc.nextInt();
			boolean idlogin=login.adminLoginDetails(adid);
		if(idlogin==true) 
		{
			List<Order> orderList = order.orderList();
			System.out.println(orderList);
		  }
		 else
			System.out.println("Invalid Input");
			
		}	

}}
