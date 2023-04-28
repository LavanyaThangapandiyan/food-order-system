package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.food.model.Customer;
import com.food.util.ConnectionUtil;



public class CustomerImpl implements CustomerDao
{

	@Override
	public void saveCustomerDetails(Customer cus) throws ClassNotFoundException, SQLException {
		
		Connection con=ConnectionUtil.getConnection();
		String s="insert into customer(id,email,phone_no,first_name,last_name,payment_id,food_id)values(?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setInt(1,cus.getId());
		ps.setString(2,cus.getEmail());
		ps.setString(3,cus.getPhoneNo());
		ps.setString(4, cus.getFirstName());
		ps.setString(5, cus.getLastName());
		ps.setInt(6, cus.getPaymentId());
		ps.setInt(7, cus.getFoodId());
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		
	}
	@Override
	public List<Customer> customerList() throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
	    Connection con=ConnectionUtil.getConnection();
	    String s="select id,email,phone_no,first_name,last_name,payment_id,food_id from customer ";
	    PreparedStatement ps=con.prepareStatement(s);
	    ResultSet rs=ps.executeQuery();
	    ArrayList list=new ArrayList<>();
	    while(rs.next())
	    {
	    	int id=rs.getInt(1);
	    	String email=rs.getString(2);
	    	String phone=rs.getString(3);
	    	String firstName=rs.getString(4);
	    	String lastName=rs.getString(5);
	    	int payment=rs.getInt(6);
	    	int foodId=rs.getInt(7);
	    	Customer cs=new Customer();
	    	cs.setId(id);
	    	cs.setEmail(email);
	    	cs.setPhoneNo(phone);
	    	cs.setFirstName(firstName);
	    	cs.setLastName(lastName);
	    	cs.setPaymentId(payment);
	    	cs.setFoodId(foodId);
	    	list.add(cs);
	    	
	    }	
		return list;
	}
	@Override
	public int updateCustomerPhoneNo(int customerId,String phoneNo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="update customer set phone_no='"+phoneNo+"' where id='"+customerId+"'";
		PreparedStatement ps=con.prepareStatement(s);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}

	@Override
	public int deleteCustomerDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Do you want Delete the Customer Details: \n Please Enter the Customer ID:");
		int id=sc.nextInt();
		Connection con=ConnectionUtil.getConnection();
		String s="delete from customer where id='"+id+"'";
		PreparedStatement ps=con.prepareStatement(s);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}

	@Override
	public void findCustomerPaymentId(int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select id,payment_id from customer where id='"+customerId+"'");
		while(rs.next())
			System.out.println(rs.getString(1)+"\t"+rs.getString(2));
	}

	@Override
	public void findCustomerName(int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select id,first_name,last_name from customer where id='"+customerId+"'");
		while(rs.next())
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		
	}
	@Override
	public void findCustomerPhoneNumber(int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select id,first_name,phone_no from customer where id='"+customerId+"'");
		while(rs.next())
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		
	}

	
	

}
