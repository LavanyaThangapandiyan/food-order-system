package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.food.model.Administrator;
import com.food.util.ConnectionUtil;
import com.food.validation.Validation;


public class AdministratorImpl implements AdministratorDao{

	Validation valid =new Validation();
	@Override
	//Save Administrator Details
	public void saveAdminDetails(Administrator admin) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String insert="insert into administrator(first_name,last_name,user_name,password,menu_id)values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(insert);
		boolean firstName=valid.nameValidation(admin.getFirstName());
		boolean lastName=valid.nameValidation(admin.getLastName());
		boolean userName=valid.nameValidation(admin.getUserName());
		boolean password=valid.passwordValidation(admin.getPassword());
		boolean menuId=valid.idValidation(admin.getMenuId());
		if(firstName==true&&lastName==true&&userName&&password==true&&menuId==true )
		{
		ps.setString(1, admin.getFirstName());
		ps.setString(2, admin.getLastName());
		ps.setString(3, admin.getUserName());
		ps.setString(4, admin.getPassword());
		ps.setInt(5, admin.getMenuId());
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		}
		else
			System.out.println("Invalid Admin Details");
	}
    //Delete Administrator details
	@Override
	public void deleteAdminDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Admin id");
		int adminId=sc.nextInt();
		String delete="delete from administrator where id=?";
		PreparedStatement ps=con.prepareStatement(delete);
		ps.setInt(1, adminId);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
	}
    // Update Admin Password By Using Admin Id
	@Override
	public void updatePassword(int adminId, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String updatePassword="update administrator set password=? where id=?";
		boolean passwd=valid.passwordValidation(password);
		boolean num=valid.numberValidation(adminId);
		if(passwd==true&&num==true) {
		PreparedStatement ps=con.prepareStatement(updatePassword);
			ps.setString(1, password);
			ps.setInt(2, adminId);	
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);	
		}else
			System.out.println("Invalid");
	}
    //Update User Name By Using Admin Id
	@Override
	public void updateUserName(int adminId, String userName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String updateName="update administrator set user_name=? where id=?";
		PreparedStatement ps=con.prepareStatement(updateName);
		boolean number=valid.numberValidation(adminId);
		boolean name=valid.nameValidation(userName);
		if(number==true&&name==true) {
			ps.setString(1, userName);
			ps.setInt(2, adminId);
			int executeUpdate = ps.executeUpdate();
			System.out.println(executeUpdate);	
		}
		else
			System.out.println("Invalid");
	}
    // Find Menu Id BY Using Admin Id
	@Override
	public void findMenuId(int adminId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String find="select menu_id from administrator where id=?";
		PreparedStatement ps=con.prepareStatement(find);
		ps.setInt(1, adminId);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			System.out.println(rs.getString(1));
		
	}

}
