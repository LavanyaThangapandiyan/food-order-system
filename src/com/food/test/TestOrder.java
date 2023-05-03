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
		//order.deleteOrderDetails();
		//---->insert */
				System.out.println("Enter Order ID:");
			    int id=sc.nextInt();
			    System.out.println("Enter Date ");
			    String date=sc.next(); 
			    System.out.println("Enter Customer Id");
			    int customerId=sc.nextInt();
			    System.out.println("Enter Quantity");
			    int quantity=sc.nextInt();
			    System.out.println("Enter Food Id");
			     int foodId=sc.nextInt();   
			        Order or=new Order();
			        if(id>10) {
			        	or.setId(id);
			        Pattern p=Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
			        Matcher m=p.matcher(date);
			        boolean a=m.matches();
			        if(a) {
			        	or.setDate(date);
			        if(customerId>0) {
			        or.setCustomerId(customerId);
			        if(quantity>0) {
			        or.setQuantity(quantity);
			        if(foodId>=2000) {
			        	or.setFoodId(foodId);
			        order.saveOrderDetails(or);}
			        else
			        	System.out.println("Invalid Food ID");
			        }else
			        	System.out.println("Invalid Quantity");
			        }else
			        	System.out.println("Invalid Customer ID");
			        }else
			        	System.out.println("Invalid Date");
			        }else
			        	System.out.println("Invalid Order Id");
			
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
        if(quantity>0)
        order.updateOrderQuantity(orderId, quantity);*/
       
		
				
		/*List<Order> orderList = order.orderList();
		System.out.println(orderList);*/
		
		
			
		
	}

}
