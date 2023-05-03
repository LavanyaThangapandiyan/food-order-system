package com.food.dao;

import java.sql.SQLException;
import java.util.List;

import com.food.model.Payment;

public interface PaymentDao {
	public void savePaymentDetails(Payment pay) throws ClassNotFoundException, SQLException;
	public List<Payment> paymentDetailsList() throws ClassNotFoundException, SQLException;
	public int deletePaymentDetails() throws ClassNotFoundException, SQLException;
	
	

}
