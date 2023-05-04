package com.food.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.food.dao.CustomerImpl;
import com.food.model.Customer;
import com.food.util.ConnectionUtil;

public class TestCustomer {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//ConnectionUtil.getConnection();
        Scanner sc=new Scanner(System.in);
        CustomerImpl customer =new CustomerImpl();
        Customer cs=new Customer();
        
        // -->delete customer details
         
       
		//customer.deleteCustomerDetails();
		
      //==>update
       System.out.println("Do you want Update the Customer Phone Number \n Please Enter Customer Id");
       int customerId=sc.nextInt();
       System.out.println("Enter your New Mobile Number:");
       String phoneNumber=sc.next();
       cs.setId(customerId);
       cs.setPhoneNumber(phoneNumber);
    	  customer.updateCustomerPhoneNumber(customerId, phoneNumber);
       }
       
     /* //---->insert
        System.out.println("Enter Customer Id:");
        int id=sc.nextInt();
        System.out.println("Enter Customet Email id:");
        String email=sc.next();
        System.out.println("Enter Customer Mobile Number");
        String phoneNo="8865421310";
        sc.next();
        System.out.println("Enter Customer Name:");
        String name=sc.next();
        Customer cs=new Customer();
        cs.setId(id);
        cs.setEmail(email);
        cs.setPhoneNumber(phoneNo);
        cs.setName(name);
        customer.saveCustomerDetails(cs);*/
        
        
        
     /* System.out.println(" IF you Want Find Customer Nmae--> Enter 1 \n Customer Phone Number -->Enter 2");
		int number=sc.nextInt();
	    if(number==1)
		{
			System.out.println("Enter Customer ID:");
			int customerId=sc.nextInt();
			if(customerId>0)
			customer.findCustomerName(customerId);
			else
				System.out.println("Invalid ID");
		}
		else if(number==2)
		{
			System.out.println("Enter Customer ID:");
			int customerId=sc.nextInt();
			if(customerId>0)
			customer.findCustomerPhoneNumber(customerId);
			else
				System.out.println("Invalid ID..");
		}
		else
			System.out.println("Invalid Input");
	}*/
       
       
        
        //-->list
       /* List<Customer> customerList = customer.customerList();
        System.out.println(customerList);*/
             
        
	
}
