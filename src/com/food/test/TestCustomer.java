package com.food.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.food.dao.CustomerImpl;
import com.food.model.Customer;
import com.food.util.ConnectionUtil;

public class TestCustomer {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//ConnectionUtil.getConnection();
        Scanner sc=new Scanner(System.in);
        CustomerImpl customer =new CustomerImpl();
        
        
        System.out.println("If you Want Find Customer Payment ID-->Enter 1 \n IF you Want Find Customer Nmae--> Enter 2 \n Customer Phone Number -->Enter 3");
		int number=sc.nextInt();
		if(number==1)
		{
		System.out.println("Enter Customer ID:");
		int customerId=sc.nextInt();
		customer.findCustomerPaymentId(customerId);;
		
		}
		else if(number==2)
		{
			System.out.println("Enter Customer ID:");
			int customerId=sc.nextInt();
			if(customerId>0)
			customer.findCustomerName(customerId);
			else
				System.out.println("Invalid ID");
		}
		else if(number==3)
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
		
		
        
        //==>update
        /*System.out.println("Do you want Update the Customer Phone Number \n Please Enter Customer Id");
        int customerId=sc.nextInt();
        System.out.println("Enter your New Mobile Number:");
        String phoneNo=sc.next();
        customer.updateCustomerPhoneNo(customerId, phoneNo);*/
        
        //-->delete
        //customer.deleteCustomerDetails();
        
        /*//-->list
        List<Customer> customerList = customer.customerList();
        System.out.println(customerList);*/
             
        
        //---->insert 
       /* int id=5;
        String email="Lav1726@gmail.com";
        String phoneNo="9865421310";
        String firstName="Lavanya";
        String lastName="Thangapandiyan";
        int paymentId=1004;
        int foodId=100004;
        Customer cs=new Customer();
        cs.setId(id);
        cs.setEmail(email);
        cs.setPhoneNo(phoneNo);
        cs.setFirstName(firstName);
        cs.setLastName(lastName);
        cs.setPaymentId(paymentId);
        cs.setFoodId(foodId);
        customer.saveCustomerDetails(cs);*/
        
        
	}

}
