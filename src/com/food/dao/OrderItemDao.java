package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import com.food.model.OrderItem;

public interface OrderItemDao {
	public void saveOrderItemDetails(OrderItem orit) throws ClassNotFoundException, SQLException;
	public List<OrderItem> orderItemList();
	public int deleteOrderItemDetails();
	public void updateOrderQuantity(int orderId,int quantity);
	public void findFoodId(int orderId);
	public void findUnitPrice(int orderId);
	
	

}
