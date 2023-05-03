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
		System.out.println("Enter Date");
		String date=sc.next();
		System.out.println("Enter Payment Type");
		String type=sc.next();
		System.out.println("Enter Amount");
		int amount=sc.nextInt();
		Payment obj=new Payment();
		if(id>100000){
			obj.setId(id);	
		if(customerId>=1){
			obj.setCustomerId(customerId);
		if(orderId>=10) {
			obj.setOrderId(orderId);
			    Pattern p=Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
		       Matcher m=p.matcher(date);
		       boolean am=m.matches();
		       if(am) {
		    	   obj.setPaymentDate(date);
		    	   if(amount>0)
			    		  obj.setAmount(amount);
		    	   Pattern p1=Pattern.compile("[a-zA-Z]+");
		    	   Matcher m1=p1.matcher(type);
		    	   boolean typ=m1.matches();
		    	   if(typ) {
		    		   obj.setPaymentType(type);
		    	   pay.savePaymentDetails(obj);
		       }else
		    	   System.out.println("Invalid Payment Type");
		}else
			System.out.println("Invalid Date");
		}else
			System.out.println("Invalid Order Id");
		}else
			System.out.println("Invalid Customer Id");
	   } else
		   System.out.println("Invalid Id");
		/*List<Payment> paymentDetailsList = pay.paymentDetailsList();
		System.out.println(paymentDetailsList);*/
		
	}

}
