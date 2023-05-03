package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.food.model.Administrator;
import com.food.util.ConnectionUtil;


public class AdministratorImpl implements AdministratorDao{

	@Override
	public void saveAdminDetails(Administrator admin) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="insert into administrator(id,f_name,l_name,user_name,password,menu_id)values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setInt(1, admin.getId());
		ps.setString(2, admin.getFirstName());
		ps.setString(3, admin.getLastName());
		ps.setString(4, admin.getUserName());
		ps.setString(5, admin.getPassword());
		ps.setInt(6, admin.getMenuId());
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		
	}

	@Override
	public int deleteAdminDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Do you want Delete Admin Details \n Please Enter Admin Id: ");
		int adminId=sc.nextInt();
		String s="delete from administrator where id='"+adminId+"'";
		PreparedStatement ps=con.prepareStatement(s);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}

	@Override
	public void updatePassword(int adminId, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="update administrator set password='"+password+"' where id='"+adminId+"'";
		PreparedStatement ps=con.prepareStatement(s);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);	
	}

	@Override
	public void updateUserName(int adminId, String userName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="update administrator set userName='"+userName+"' where id='"+adminId+"'";
		PreparedStatement ps=con.prepareStatement(s);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);	
	}

	@Override
	public void findMenuId() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String s="select menuId from admin ";
		PreparedStatement ps=con.prepareStatement(s);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			System.out.println(rs.getString(1));
		
	}

}
