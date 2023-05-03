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
		String s="insert into customer(id,email,phone_no,name)values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setInt(1,cus.getId());
		ps.setString(2,cus.getEmail());
		ps.setString(3,cus.getPhoneNo());
		ps.setString(4, cus.getName());
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		
	}
	@Override
	public List<Customer> customerList() throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
	    Connection con=ConnectionUtil.getConnection();
	    String s="select id,email,phone_no,name from customer ";
	    PreparedStatement ps=con.prepareStatement(s);
	    ResultSet rs=ps.executeQuery();
	    ArrayList list=new ArrayList<>();
	    while(rs.next())
	    {
	    	int id=rs.getInt(1);
	    	String email=rs.getString(2);
	    	String phone=rs.getString(3);
	    	String name=rs.getString(4);
	    	
	    	Customer cs=new Customer();
	    	cs.setId(id);
	    	cs.setEmail(email);
	    	cs.setPhoneNo(phone);
	    	cs.setName(name);
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
	public void findCustomerName(int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select id,name from customer where id='"+customerId+"'");
		while(rs.next())
			System.out.println(rs.getString(1)+"\t"+rs.getString(2));
		
	}
	@Override
	public void findCustomerPhoneNumber(int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select id,name,phone_no from customer where id='"+customerId+"'");
		while(rs.next())
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		
	}

	
	

}
