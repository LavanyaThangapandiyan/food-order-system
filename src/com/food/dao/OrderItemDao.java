package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import com.food.model.OrderItem;

public interface OrderItemDao {
	public void saveOrderItemDetails(OrderItem orit) throws ClassNotFoundException, SQLException;
	public List<OrderItem> orderItemList() throws ClassNotFoundException, SQLException;
	public int deleteOrderItemDetails() throws ClassNotFoundException, SQLException;

}
