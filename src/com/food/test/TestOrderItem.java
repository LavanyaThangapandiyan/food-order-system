package com.food.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.food.dao.OrderItemImpl;
import com.food.model.OrderItem;
import com.food.util.ConnectionUtil;

public class TestOrderItem {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//ConnectionUtil.getConnection();
		OrderItemImpl or=new OrderItemImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Order Id");
		int orderId=sc.nextInt();
		System.out.println("Enter Food ID");
		int foodId=sc.nextInt();
		OrderItem ord=new OrderItem();
			ord.setId(orderId);
				ord.setFoodId(foodId);
        or.saveOrderItemDetails(ord);

		
		//or.deleteOrderItemDetails();
		
		/*List<OrderItem> orderItemList = or.orderItemList();
		System.out.println(orderItemList);}*/
}
}