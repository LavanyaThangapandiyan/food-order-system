package com.food.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.food.dao.PaymentDaoImpl;
import com.food.model.Payment;
import com.food.util.ConnectionUtil;
import com.login.details.Login;

public class TestPayment 
{
	public static void main(String[]args) throws ClassNotFoundException, SQLException
	{
		//ConnectionUtil.getConnection();
		
		PaymentDaoImpl pay=new PaymentDaoImpl();
		Payment obj=new Payment();
		Scanner sc=new Scanner(System.in);
		Login login=new Login();
		System.out.println("Admin Login ==>1 \n Customer Login ==>2");
		int number=sc.nextInt();
		if(number==1)
		{
		System.out.println("enter your Admin id:");
		int adminId = sc.nextInt();
		boolean adminLogin = login.adminLoginDetails(adminId);
		if(adminLogin== true) 
		 {
			System.out.println("1. show payment details \n 2. Delete Payment Details");
			int option=sc.nextInt();
			switch(option)
			 {
				case 1:
				{
					List<Payment> paymentDetailsList = pay.paymentDetailsList();
					System.out.println(paymentDetailsList);	
					break;
				}
				case 2:
				{
					pay.deletePaymentDetails();
					break;
				}
			}}else
				System.out.println("Invalid ID");
		}else if(number==2)
		 {
			   System.out.println("Enter Customer Id:");
				int customerId=sc.nextInt();
				System.out.println("Enter Order ID");
				int orderId=sc.nextInt();
				System.out.println("Enter Payment Type");
				String type=sc.next();
				   obj.setCustomerId(customerId);
				  obj.setOrderId(orderId); 
				  obj.setPaymentType(type);
				  
		 }  }
	  
		
		}	
		


