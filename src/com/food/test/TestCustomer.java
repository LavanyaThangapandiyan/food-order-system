package com.food.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.food.dao.CustomerImpl;
import com.food.model.Customer;
import com.food.model.Menu;
import com.food.util.ConnectionUtil;
import com.login.details.Login;

public class TestCustomer {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//ConnectionUtil.getConnection();
        Scanner sc=new Scanner(System.in);
        CustomerImpl customer =new CustomerImpl();
        Login login=new Login();
        Customer cs=new Customer();
        System.out.println("Customer Login ==>1 \n Admin Login Enter==>2");
        int number=sc.nextInt();
        if(number==1)
        {
        System.out.println("If you are Customer \n Exsisting Customer Enter==>1 New Customer enter==> 2 ");
        int ans=sc.nextInt();
             if(ans==1) 
             {
        	 System.out.println("enter your Customer id:");
			 int customerId = sc.nextInt();
			 boolean customerLogin = login.customerLoginDetails(customerId);
			if(customerLogin == true) 
			 {
				System.out.println("Do you want Update the Customer Phone Number \n Please Enter Customer Id");
			       int customerId1=sc.nextInt();
			       System.out.println("Enter your New Mobile Number:");
			       String phoneNumber=sc.next();
			       cs.setId(customerId1);
			       cs.setPhoneNumber(phoneNumber);
			    	  customer.updateCustomerPhoneNumber(customerId1, phoneNumber);
				
			}
			else
				System.out.println("Invalid ID");
			}
			else if(ans==2) 
			{
                             System.out.println("Please enter the details :");
                             System.out.println("Enter Customet Email id:");
                             String email=sc.next();
                             System.out.println("Enter Customer Mobile Number");
                             String phoneNo=sc.next();
                             System.out.println("Enter Customer Name:");
                             String name=sc.next();
                             cs.setEmail(email);
                             cs.setPhoneNumber(phoneNo);
                             cs.setName(name);
                             customer.saveCustomerDetails(cs);
             }
             }else if(number==2)
	        {
            	System.out.println("enter your Admin id:");
    			int adminId = sc.nextInt();
    			boolean adminLogin = login.adminLoginDetails(adminId);
    			if(adminLogin== true) 
    			 {
				System.out.println(" IF you Want Find Customer Name--> Enter 1 \n Find Customer Phone Number -->Enter 2\n  ==>Show Customer List==>3 \n delete Customer Details ==>4");
				int num=sc.nextInt();
			    switch(num) 
			    {
			    case 1:
			    {
					System.out.println("Enter Customer ID:");
					int customerId1=sc.nextInt();
					if(customerId1>0)
					customer.findCustomerName(customerId1);
					else
						System.out.println("Invalid ID");
					break;
				}
			    case 2:
				{
					System.out.println("Enter Customer ID:");
					int customerId1=sc.nextInt();
					if(customerId1>0)
					customer.findCustomerPhoneNumber(customerId1);
					else
						System.out.println("Invalid ID..");
					break;
				}
			    case 3:
			    {		       
				System.out.println(" show Customer  List ");
				List<Customer> customerList = customer.customerList();
		        System.out.println(customerList);
		        break;
		        }
		        case 4:
		        {
		        System.out.println("Delete customer Details");
		        customer.deleteCustomerDetails();
	             }
			    }}else
			    	System.out.println("Invalid Id");
			    
			   
			    	
}}}
		      
