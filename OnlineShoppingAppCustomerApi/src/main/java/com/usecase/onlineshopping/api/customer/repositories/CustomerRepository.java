package com.usecase.onlineshopping.api.customer.repositories;

import javax.persistence.Entity;

import org.springframework.data.repository.CrudRepository;

import com.usecase.onlineshopping.api.customer.data.Customer;  


public interface CustomerRepository extends CrudRepository<Customer, Long>   
{
	
}    
