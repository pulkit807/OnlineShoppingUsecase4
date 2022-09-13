package com.usecase.onlineshopping.api.customer.service;

import java.util.List;

import com.usecase.onlineshopping.api.customer.data.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer createCustomer(Customer customer);
	public void deleteCustomer(long custId);

}
