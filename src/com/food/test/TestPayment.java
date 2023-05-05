package com.food.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.food.dao.PaymentDaoImpl;
import com.food.model.Payment;
import com.food.util.ConnectionUtil;

public class TestPayment 
{
	public static void main(String[]args) throws ClassNotFoundException, SQLException
	{
		//ConnectionUtil.getConnection();
		PaymentDaoImpl pay=new PaymentDaoImpl();
	 //pay.deletePaymentDetails();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Payment id:");
		int id=sc.nextInt();
		System.out.println("Enter Customer Id:");
		int customerId=sc.nextInt();
		System.out.println("Enter Order ID");
		int orderId=sc.nextInt();
		System.out.println("Enter Payment Type");
		String type=sc.next();
		System.out.println("Enter Amount");
		int amount=sc.nextInt();
		Payment obj=new Payment();
			obj.setId(id);	
			obj.setCustomerId(customerId);
			obj.setOrderId(orderId);
		   obj.setAmount(amount);
		    obj.setPaymentType(type);
		   pay.savePaymentDetails(obj);
	   
		/*List<Payment> paymentDetailsList = pay.paymentDetailsList();
		System.out.println(paymentDetailsList);*/
		
	}

}
