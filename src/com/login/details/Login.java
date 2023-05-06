package com.login.details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.food.util.ConnectionUtil;

public class Login {
	public boolean customerLoginDetails(int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select id from customer where id=?";
		PreparedStatement ps = con.prepareStatement(find);
		ps.setInt(1, customerId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1);
			if (customerId == id) 
				return true;
		}
		return false;
	}
	
	public boolean adminLoginDetails(int adminId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find ="select id from administrator where id=?";
		PreparedStatement ps=con.prepareStatement(find);
		ps.setInt(1, adminId);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt(1);
			if(adminId==id)
				return true;
		}
		return false;
	}
	

}
