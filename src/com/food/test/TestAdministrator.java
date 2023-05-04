package com.food.test;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.food.dao.AdministratorImpl;
import com.food.model.Administrator;
import com.food.util.ConnectionUtil;
import com.food.validation.Validation;

public class TestAdministrator {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//ConnectionUtil.getConnection();
		AdministratorImpl admin=new AdministratorImpl();
		Scanner sc=new Scanner(System.in);
		
	// ==>Insert Admin Details
		/*Administrator obj=new Administrator();
		System.out.println("Enter Admin Id");
		int id=sc.nextInt();
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
		obj.setId(id);
        obj.setFirstName(firstName);
		obj.setLastName(lastName);
		obj.setUserName(userName);
		obj.setPassword(password);
		obj.setMenuId(menuId);
		admin.saveAdminDetails(obj);*/
		
		//==>Delete Admin Details
		//admin.deleteAdminDetails();
	
		
		/*//Here Update Admin Password 
		    System.out.println("Do you want update Password");
			System.out.println("Enter Admin Id");
			int adminId=sc.nextInt();
			System.out.println("Enter Admin Password");
			String password=sc.next();
			admin.updatePassword(adminId, password);*/
			
			
			
			//==>update admin Name
			/*System.out.println("Do ypu want update Name");
			System.out.println("Enter Admin Id");
			int adminId=sc.nextInt();
			System.out.println("Enter new Name");
			String userName=sc.next();
			admin.updateUserName(adminId, userName);*/
			
			//==>Find Menu id in Administrator
			 System.out.println("Do you want Find menu Id \n Enter the Admin ID");
			int adminId=sc.nextInt();
			admin.findMenuId(adminId);
				
	}		
			
		
	}
