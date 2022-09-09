package com.usecase.onlineshopping.api.items.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;  
    
public interface ItemRepository extends CrudRepository<Item, Integer>   
{
	List<Item> findByName(String name);
}    
