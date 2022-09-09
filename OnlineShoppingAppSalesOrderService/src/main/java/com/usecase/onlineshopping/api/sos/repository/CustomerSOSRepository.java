package com.usecase.onlineshopping.api.sos.repository;

import org.springframework.data.repository.CrudRepository;

import com.usecase.onlineshopping.api.sos.model.CustomerSOS;  
    
public interface CustomerSOSRepository extends CrudRepository<CustomerSOS, Long>   
{
	
}    
