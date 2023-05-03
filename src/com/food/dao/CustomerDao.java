package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import com.food.model.Customer;

public interface CustomerDao 
{
public void saveCustomerDetails(Customer cus) throws ClassNotFoundException, SQLException;
public int  updateCustomerPhoneNo(int customerId,String phoneNo) throws ClassNotFoundException, SQLException;
public int  deleteCustomerDetails() throws ClassNotFoundException, SQLException;
public void findCustomerName(int customerId) throws ClassNotFoundException, SQLException;
public void findCustomerPhoneNumber(int customerId) throws ClassNotFoundException, SQLException;
public List<Customer> customerList() throws ClassNotFoundException, SQLException;
}
