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
		String insert="insert into administrator(id,first_name,last_name,user_name,password,menu_id)values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(insert);
		boolean id=valid.idValidation(admin.getId());
		boolean firstName=valid.nameValidation(admin.getFirstName());
		boolean lastName=valid.nameValidation(admin.getLastName());
		boolean userName=valid.nameValidation(admin.getUserName());
		boolean password=valid.passwordValidation(admin.getPassword());
		boolean menuId=valid.menuIdValidation(admin.getMenuId());
		if(id==true) {
		ps.setInt(1, admin.getId());
		if(firstName==true) {
		ps.setString(2, admin.getFirstName());
		if(lastName==true) {
		ps.setString(3, admin.getLastName());
		if(userName==true) {
		ps.setString(4, admin.getUserName());
		if(password==true) {
		ps.setString(5, admin.getPassword());
		if(menuId==true) {
		ps.setInt(6, admin.getMenuId());
		}else
			System.out.println("Invalid Menu Id");
		}else
			System.out.println("Invalid Password");
		}else
			System.out.println("Invalid User Name");
		}else
			System.out.println("Invalid Last Name");
		}else
			System.out.println("Invalid First Name");
		}else
			System.out.println("Invalid ID");
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		
	}
    //Delete Administrator details
	@Override
	public int deleteAdminDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("check the id is there ? Please enter the id ");
		int id=sc.nextInt();
		String find="select id from administrator where id=?";
		PreparedStatement psfind=con.prepareStatement(find);
		psfind.setInt(1,id);
		ResultSet rs=psfind.executeQuery();
		while(rs.next())
			System.out.println("The Id Is there:"+rs.getInt(1));
		System.out.println("Do you want delete Admin Details \n Enter Admin ID");
		int adminId=sc.nextInt();
		String delete="delete from administrator where id=?";
		PreparedStatement ps=con.prepareStatement(delete);
		ps.setInt(1, adminId);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);
		return executeUpdate;
	}
    // Update Admin Password By Using Admin Id
	@Override
	public void updatePassword(int adminId, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String updatePassword="update administrator set password=? where id=?";
		PreparedStatement ps=con.prepareStatement(updatePassword);
			ps.setString(1, password);
			ps.setInt(2, adminId);	
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);	
	}
    //Update User Name By Using Admin Id
	@Override
	public void updateUserName(int adminId, String userName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionUtil.getConnection();
		String updateName="update administrator set user_name=? where id=?";
		PreparedStatement ps=con.prepareStatement(updateName);
		ps.setString(1, userName);
		ps.setInt(2, adminId);
		int executeUpdate = ps.executeUpdate();
		System.out.println(executeUpdate);	
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
