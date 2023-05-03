package com.food.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.food.dao.MenuImpl;
import com.food.model.Menu;
import com.food.util.ConnectionUtil;

public class TestMenu {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//ConnectionUtil.getConnection();
		MenuImpl menu=new MenuImpl();
		Scanner sc=new Scanner(System.in);
		//-->insert
		       System.out.println("Enter Menu ID");
				int id=sc.nextInt();
				System.out.println("Enter Food Id");
				int foodId=sc.nextInt();
				Menu obj=new Menu();
				if(id>1000) {
				obj.setId(id);
				if(foodId>=2000) {
				obj.setFoodId(foodId);
				menu.saveMenuDetails(obj);
				}else
					System.out.println("Invalid Food Id");
				}else
					System.out.println("Invalid Menu Id");
		
		
		//menu.deleteMenuDetails();
		
		//List<Menu> menuList = menu.menuList();
		//System.out.println(menuList);
		
		
		

	}

}
