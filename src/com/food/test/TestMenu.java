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
				obj.setId(id);
				obj.setFoodId(foodId);
				menu.saveMenuDetails(obj);
		
		
		//menu.deleteMenuDetails();
		
		//List<Menu> menuList = menu.menuList();
		//System.out.println(menuList);
		
		
		

	}

}
