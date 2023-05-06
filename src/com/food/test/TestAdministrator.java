package com.food.test;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.food.dao.AdministratorImpl;
import com.food.model.Administrator;
import com.food.model.Customer;
import com.food.util.ConnectionUtil;
import com.food.validation.Validation;
import com.login.details.Login;

public class TestAdministrator
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//ConnectionUtil.getConnection();
		Scanner sc=new Scanner(System.in);
		AdministratorImpl admin=new AdministratorImpl();
		Administrator obj=new Administrator();
		Login login = new Login();
	        System.out.println("If you are  \n New Customer Enter==>1 \n Exsisting Customer enter==> 2 ");
	        int number=sc.nextInt();
	        if(number==1)
	        {
		     System.out.println("Enter First Name");
		     String firstName=sc.next();
		     System.out.println("Enter Last Name");
		     String lastName=sc.next();
		     System.out.println("Enter User Name");
		    String userName=sc.next();
		    System.out.println("Enter Password");
		    String password=sc.next();
		    System.out.println("Enter Menu Id");
		    int menuId=sc.nextInt();
             obj.setFirstName(firstName);
		     obj.setLastName(lastName);
		     obj.setUserName(userName);
		     obj.setPassword(password);
		    obj.setMenuId(menuId);
		    admin.saveAdminDetails(obj);
		    }
	        else if(number==2)
	        {
	        	System.out.println("enter your Admin id:");
	    		int adminId = sc.nextInt();
	    		boolean adminLogin = login.adminLoginDetails(adminId);
	    		if(adminLogin== true) 
	    		{
	    			System.out.println("1. Update Password \n2.Update Admin Name \n 3.Find Menu Id \n 4. Delete Admin Details");
	    			int option=sc.nextInt();
	    			switch(option)
	    			{
	    			case 1:
	    			{
	    				System.out.println("Do you want update Password");
	    				System.out.println("Enter Admin Id");
	    				int adminId1=sc.nextInt();
	    				System.out.println("Enter Admin Password");
	    				String password=sc.next();
	    				admin.updatePassword(adminId1, password);
	    				break;
	    			}
	    			case 2:
	    			{
	    				System.out.println("Do you want update Name");
	    				System.out.println("Enter Admin Id");
	    				int adminId1=sc.nextInt();
	    				System.out.println("Enter new Name");
	    				String userName=sc.next();
	    				admin.updateUserName(adminId1, userName);
	    				break;
	    			}
	    			case 3:
	    			{
	    				System.out.println("Do you want Find menu Id \n Enter the Admin ID");
	    				int adminId1=sc.nextInt();
	    				admin.findMenuId(adminId1);
	    				break;
	    			}
	    			case 4:
	    			{
	    				admin.deleteAdminDetails();
	    				break;
	    			}
	    			}
	    		}else
	    				System.out.println("Invalid Input");
	    		}
	        }
	}		

