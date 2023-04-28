package com.food.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.food.dao.OrderImpl;
import com.food.model.Order;
import com.food.util.ConnectionUtil;

public class TestOrder {
	public static void main(String[]args) throws ClassNotFoundException, SQLException
	{
		//ConnectionUtil.getConnection();
		Scanner sc=new Scanner(System.in);
		OrderImpl order=new OrderImpl();
		
		
		System.out.println("Do you Want Find Order Quantity --> Enter 1\n Do you want Find Order Pickup Date -->Enter 2 ");
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
				order.findOrderPickupDate(orderId);
				
		}
		
		 //==>update
        /*System.out.println("Do you want Update the Order Quantity \n Please Enter Order Id");
        int orderId=sc.nextInt();
        System.out.println("Enter your New Quantity:");
        int quantity=sc.nextInt();
        order.updateOrderQuantity(orderId, quantity);
       
		
				
		/*List<Order> orderList = order.orderList();
		System.out.println(orderList);
		
		
			
		//---->insert 
	      /*  int id=3;
	        String date="2023-01-11";
	        int customerId=2;
	        int quantity=2;
	        String pickupDate="2023-01-11";
	        Order or=new Order();
	        or.setId(id);
	        or.setDate(date);
	        or.setCustomerId(customerId);
	        or.setQuantity(quantity);
	        or.setPickupDate(pickupDate);
	        order.saveOrderDetails(or);*/
	}

}
