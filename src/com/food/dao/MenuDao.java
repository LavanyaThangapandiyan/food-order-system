package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import com.food.model.Menu;

public interface MenuDao 
{
	public void saveMenuDetails(Menu menu) throws ClassNotFoundException, SQLException;
	public List<Menu> menuList() throws ClassNotFoundException, SQLException;
	public int deleteMenuDetails() throws ClassNotFoundException, SQLException;
	

}
