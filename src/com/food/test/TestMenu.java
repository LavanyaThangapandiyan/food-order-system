package com.food.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.food.dao.MenuImpl;
import com.food.model.Menu;
import com.food.util.ConnectionUtil;
import com.login.details.Login;

public class TestMenu {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//ConnectionUtil.getConnection();
	   
		MenuImpl menu=new MenuImpl();
		Menu obj=new Menu();
		Login login=new Login();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Customer Login==>Enter 1\n ADMIN login ==>Enter 2");
		int number=sc.nextInt();
		if(number==1)
		{
			System.out.println("enter your Customer id:");
			int customerId = sc.nextInt();
			boolean customerLogin = login.customerLoginDetails(customerId);
			
			if (customerLogin == true) 
			{
				System.out.println("your menu :");
				List<Menu> menuList = menu.menuList();
				System.out.println(menuList);
			}else
				System.out.println("Invalid Customer Id");
		}else if(number==2) {
				System.out.println("select the option \n insert menu details==>1 \n delete menu==>2\n show menu List ==>3");
				int option = sc.nextInt();
				switch (option) {
				case 1: {
					 System.out.println("Enter Menu ID");
						int id=sc.nextInt();
						System.out.println("Enter Food Id");
						int foodId=sc.nextInt();
						obj.setId(id);
						obj.setFoodId(foodId);
						menu.saveMenuDetails(obj);	
				}
					break;
				case 2:{
					menu.deleteMenuDetails();
				}
					break;
				case 3: {
					List<Menu> menuList = menu.menuList();
					System.out.println(menuList);
				}
					break;
				}
	}
}
		      
	}


