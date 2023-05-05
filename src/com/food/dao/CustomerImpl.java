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
import com.food.validation.Validation;

public class CustomerImpl implements CustomerDao
{
	Validation valid=new Validation();
//Insert Customer details
	@Override
	public void saveCustomerDetails(Customer customer) throws ClassNotFoundException, SQLException {
		boolean id=valid.idValidation(customer.getId());
		boolean email=valid.emailValidation(customer.getEmail());
		boolean phoneNumber=valid.phoneNumberValidation(customer.getPhoneNumber());
		boolean name=valid.nameValidation(customer.getName());
		Connection con=ConnectionUtil.getConnection();
		String insert="insert into customer(id,email,phone_number,name)values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(insert);
		if(id==true) {
		ps.setInt(1,customer.getId());
		if(email==true) {
		ps.setString(2,customer.getEmail());
		if(phoneNumber==true) {
		ps.setString(3,customer.getPhoneNumber());
		if(name==true) {
		ps.setString(4, customer.getName());
		}else
			System.out.println("Invalid Name");
		}else
			System.out.println("Invalid Phone Number");
		}else
			System.out.println("Invalid Email Id");
		}else
			System.out.println("Invalid Id");
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);	
	}
	//List Customer Details
	@Override
	public List<Customer> customerList() throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
	    Connection con=ConnectionUtil.getConnection();
	    String customerList="select id,email,phone_number,name from customer ";
	    PreparedStatement ps=con.prepareStatement(customerList);
	    ResultSet rs=ps.executeQuery();
	    ArrayList<Customer> customer=new ArrayList<Customer>();
	    while(rs.next())
	    {
	    	int id=rs.getInt(1);
	    	String email=rs.getString(2);
	    	String phone=rs.getString(3);
	    	String name=rs.getString(4);
	    	Customer cs=new Customer();
	    	cs.setId(id);
	    	cs.setEmail(email);
	    	cs.setPhoneNumber(phone);
	    	cs.setName(name);
	    	customer.add(cs);
	    	
	    }	
		return customer;
	}
	//Update Customer Phone Number By using Customer Id
	@Override
	public int updateCustomerPhoneNumber(int customerId,String phoneNo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Customer cus=new Customer();
		Connection con=ConnectionUtil.getConnection();
		String update="update customer set phone_number=? where id=?";
		PreparedStatement ps=con.prepareStatement(update);
		ps.setString(1,phoneNo);
		ps.setInt(2,customerId);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}
	//delete Customer Details By using Customer ID
	@Override
	public int deleteCustomerDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Connection con=ConnectionUtil.getConnection();
		System.out.println("If You want check the id is there ? \n Please enter the id ");
		int csId=sc.nextInt();
		String find="select id from customer where id=?";
		PreparedStatement ps=con.prepareStatement(find);
		ps.setInt(1,csId);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			System.out.println("Id is there"+rs.getInt(1));
		System.out.println("Do you want Delete the Customer Details: \n Please Enter the Customer ID:");
		int id=sc.nextInt();
		String delete="delete from customer where id=?";
		PreparedStatement ps1=con.prepareStatement(delete);
		ps1.setInt(1, id);
		int executeUpdate = ps1.executeUpdate();
		return executeUpdate;
	}
//Find Customer Name By using Customer ID
	@Override
	public void findCustomerName(int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String findName="select id,name from customer where id=?";
		PreparedStatement ps=con.prepareStatement(findName);
		ps.setInt(1, customerId);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			System.out.println(rs.getString(1)+"\t"+rs.getString(2));
		
	}
	//Find Customer Phone Number By using Customer ID
	@Override
	public void findCustomerPhoneNumber(int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String findPhoneNumber="select id,name,phone_number from customer where id=?";
		PreparedStatement ps=con.prepareStatement(findPhoneNumber);
		ps.setInt(1, customerId);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		
	}

	
	

}
