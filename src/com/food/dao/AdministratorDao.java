package com.food.dao;

import java.sql.SQLException;

import com.food.model.Administrator;

public interface AdministratorDao {
	public void saveAdminDetails(Administrator admin) throws ClassNotFoundException, SQLException;
    public int deleteAdminDetails() throws ClassNotFoundException, SQLException;
    public void updatePassword(int adminId,String password) throws ClassNotFoundException, SQLException;
    public void updateUserName(int adminId,String userName) throws ClassNotFoundException, SQLException;
    public void findMenuId(int adminId) throws ClassNotFoundException, SQLException;	

}
