package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.food.model.Payment;
import com.food.util.ConnectionUtil;

public class PaymentDaoImpl implements PaymentDao {

	@Override
	public void savePaymentDetails(Payment pay) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="insert into payment(id,customer_id,order_id,date,amount,type)values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setInt(1, pay.getId());
		ps.setInt(2, pay.getCustomerId());
		ps.setInt(3, pay.getOrderId());
		ps.setString(4, pay.getPaymentDate());
		ps.setDouble(5,pay.getAmount());
		ps.setString(6, pay.getPaymentType());	
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		Scanner sc=new Scanner(System.in);
		System.out.println("Ener Order Id");
		int orderId=sc.nextInt();
		String s1="select quantity,unit_price from order_item where order_id='"+orderId+"'";
		PreparedStatement ps1=con.prepareStatement(s1);	
		ResultSet rs=ps1.executeQuery();
		while(rs.next())
		{
			int quantity=rs.getInt(1);
			int unitPrice=rs.getInt(2);
			int amount=quantity*unitPrice;
			String s2="update payment set amount='"+amount+"' where order_id='"+orderId+"'";
			PreparedStatement ps2=con.prepareStatement(s2);
			int executeUpdate2 = ps2.executeUpdate();
			System.out.println(executeUpdate);
		}
		
	}

	@Override
	public List<Payment> paymentDetailsList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="select id,customer_id,order_id,date,amount,type from payment";
		PreparedStatement ps=con.prepareStatement(s);
		ResultSet rs=ps.executeQuery();
		ArrayList list=new ArrayList<>();
		while(rs.next())
		{
		 int id=rs.getInt(1);
		 int customerId=rs.getInt(2);
		 int orderId=rs.getInt(3);
		 String date=rs.getString(4);
		 int amount=rs.getInt(5);
		 String type=rs.getString(6);
		 Payment pay=new Payment();
		 pay.setId(id);
		 pay.setCustomerId(customerId);
		 pay.setOrderId(orderId);
		 pay.setPaymentDate(date);
		 pay.setAmount(amount);
		 pay.setAmount(amount);
		 list.add(pay);
		}
		return list;
	}

	@Override
	public int deletePaymentDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("If you want to delete Payment Details \n Enter Payment Id");
		int paymentId=sc.nextInt();
		String s="delete from Payment where id='"+paymentId+"'";
		PreparedStatement ps=con.prepareStatement(s);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate ;
	}
	

}
