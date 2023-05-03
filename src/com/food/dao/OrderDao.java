package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import com.food.model.Order;

public interface OrderDao {
	public void saveOrderDetails(Order or) throws ClassNotFoundException, SQLException;
	public List<Order> orderList() throws ClassNotFoundException, SQLException;
	public int deleteOrderDetails() throws ClassNotFoundException, SQLException;
	public int updateOrderQuantity(int orderId,int quantity) throws ClassNotFoundException, SQLException;
	public void findOrderQuantity(int orderId) throws ClassNotFoundException, SQLException;
	public void findOrderDate(int orderId) throws ClassNotFoundException, SQLException;
	

}
