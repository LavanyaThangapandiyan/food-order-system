package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.food.model.Payment;
import com.food.util.ConnectionUtil;
import com.food.validation.Validation;

public class PaymentDaoImpl implements PaymentDao {
	Validation valid=new Validation();
	@Override
	//Insert the Payment details
	public void savePaymentDetails(Payment pay) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Date date=new Date();
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		String insert="insert into payment(customer_id,order_id,date,type)values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(insert);
		boolean csid=valid.idValidation(pay.getCustomerId());
		boolean orId=valid.idValidation(pay.getOrderId());
		boolean type=valid.nameValidation(pay.getPaymentType());
		if(csid==true&&orId==true&&type==true) {
		ps.setInt(1, pay.getCustomerId());
		ps.setInt(2, pay.getOrderId());
		ps.setDate(3,sqldate);
		ps.setString(4, pay.getPaymentType());
		}else
			System.out.println("Invalid Payment details");
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		Scanner sc=new Scanner(System.in);
		System.out.println("Ener Order Id");
		int orderId=sc.nextInt();
		String select="select quantity,unit_price from order_item where order_id=?";
		PreparedStatement ps1=con.prepareStatement(select);
		ps1.setInt(1,orderId );
		ResultSet rs=ps1.executeQuery();
		while(rs.next())
		{
			int quantity=rs.getInt(1);
			int unitPrice=rs.getInt(2);
			int amount=quantity*unitPrice;
			String update="update payment set amount=? where order_id=?";
			PreparedStatement ps2=con.prepareStatement(update);
			ps2.setInt(1,amount);
			ps2.setInt(2,orderId);
			int executeUpdate2 = ps2.executeUpdate();
			System.out.println(executeUpdate2);
		}
		
		
	}
	@Override
	public List<Payment> paymentDetailsList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String payment="select id,customer_id,order_id,date,amount,type from payment";
		PreparedStatement ps=con.prepareStatement(payment);
		ResultSet rs=ps.executeQuery();
		ArrayList<Payment> paymentList=new ArrayList<>();
		while(rs.next())
		{
		 int id=rs.getInt(1);
		 int customerId=rs.getInt(2);
		 int orderId=rs.getInt(3);
		 Date date=rs.getDate(4);
		 int amount=rs.getInt(5);
		 String type=rs.getString(6);
		 Payment pay=new Payment();
		 pay.setId(id);
		 pay.setCustomerId(customerId);
		 pay.setOrderId(orderId);
		 pay.setPaymentDate((java.sql.Date) date);
		 pay.setAmount(amount);
		 pay.setAmount(amount);
		 pay.setPaymentType(type);
		 paymentList.add(pay);
		}
		return paymentList;}
		
	
	@Override
	public int deletePaymentDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("If you want to delete Payment Details \n Enter Payment Id");
		int paymentId=sc.nextInt();
		String delete="delete from Payment where id=?";
		PreparedStatement ps1=con.prepareStatement(delete);
		ps1.setInt(1,paymentId);
		int executeUpdate = ps1.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate ;
	}
	
	

}
