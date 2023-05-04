package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import com.food.model.Customer;

public interface CustomerDao 
{
public void saveCustomerDetails(Customer customer) throws ClassNotFoundException, SQLException;
public int  updateCustomerPhoneNumber(int customerId,String phoneNumber) throws ClassNotFoundException, SQLException;
public int  deleteCustomerDetails() throws ClassNotFoundException, SQLException;
public void findCustomerName(int customerId) throws ClassNotFoundException, SQLException;
public void findCustomerPhoneNumber(int customerId) throws ClassNotFoundException, SQLException;
public List<Customer> customerList() throws ClassNotFoundException, SQLException;
}
