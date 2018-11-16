package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Customer;
@Repository("customerDao")

public interface CustomerDao {

	void registerCustomer(Customer customer);
	boolean isEmailUnique(String email);

}
