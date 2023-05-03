package com.food.test;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.food.dao.AdministratorImpl;
import com.food.model.Administrator;
import com.food.util.ConnectionUtil;

public class TestAdministrator {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//ConnectionUtil.getConnection();
		AdministratorImpl admin=new AdministratorImpl();
		Scanner sc=new Scanner(System.in);
		//admin.deleteAdminDetails();
		//==>insert
		/*Administrator obj=new Administrator();
		int id=101;
		String firstName="kiran";
		String lastName="Kumar";
		String userName="KiranKumar26";
		String password="KiranKumar@1726";
		String status="admin user";
		int menuId=1000;
		if(id>100) {
		obj.setId(id);
		Pattern nm=Pattern.compile("[a-zA-Z]+");
        Matcher nme=nm.matcher(firstName);
        boolean mn=nme.matches();
        if(mn) {
        	obj.setFirstName(firstName);
        Pattern nm1=Pattern.compile("[a-zA-Z]+");
        Matcher nme1=nm1.matcher(lastName);
        boolean mn1=nme.matches();
        if(mn1) {
		obj.setLastName(lastName);
        Pattern nm11=Pattern.compile("[a-zA-Z]+");
        Matcher nme11=nm11.matcher(firstName);
        boolean mn11=nme.matches();
        if(mn11) {
		obj.setUserName(userName);
        Pattern nm2=Pattern.compile("[a-zA-Z]+");
        Matcher nme2=nm2.matcher(userName);
        boolean mn2=nme.matches();
        if(mn2) 
        {
		obj.setPassword(password);
        if(menuId>=1000) {
		obj.setMenuId(menuId);
		admin.saveAdminDetails(obj);
	}else
		System.out.println("Invalid Menu Id");
	}else
		System.out.println("Invalid Password");
    }else
    	System.out.println("Invalid userName ");
        }else
        	System.out.println("Invalid Last name");
	}else
		System.out.println("Invalid First name");
    }else
	System.out.println("Invalid Id");
				
	}*/
		//admin.deleteAdminDetails();
		  /* System.out.println("Do ypu want update Password");
			System.out.println("Enter Admin Id");
			int adminId=sc.nextInt();
			System.out.println("Enter Admin Password");
			String password=sc.next();
			Pattern p=Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
			 Matcher m=p.matcher(password);
		        boolean mn=m.matches();
			if(mn)
			admin.updatePassword(adminId, password);
			else
				System.out.println("Invalid data");*/
			System.out.println("Do ypu want update Name");
			System.out.println("Enter Admin Id");
			int adminId=sc.nextInt();
			System.out.println("Enter new Name");
			String name=sc.next();
			Pattern p=Pattern.compile("[a-zA-Z]+");
			 Matcher m=p.matcher(name);
		        boolean mn=m.matches();
			if(mn)
			admin.updatePassword(adminId, name);
			else
				System.out.println("Invalid data");
			
				//System.out.println("Enter Admin Id");
				//int adminId=sc.nextInt();
				
	}		
			
		
	}
