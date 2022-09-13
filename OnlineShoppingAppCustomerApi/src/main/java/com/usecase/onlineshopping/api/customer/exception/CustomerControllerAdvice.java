package com.usecase.onlineshopping.api.customer.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.usecase.onlineshopping.api.customer.service.CustomerService;

@RestControllerAdvice
public class CustomerControllerAdvice {
	@Autowired
	CustomerService customerService;
	@ExceptionHandler(value = { SalesOrderConnectionFailed.class })
    public ResponseEntity<ErrorResponse> itemsNotFoundRequest(SalesOrderConnectionFailed ex)
    {
		customerService.deleteCustomer(ex.getCustId());
		ErrorResponse err= new ErrorResponse(400, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err); 
    }
	
	@ExceptionHandler(value = { NoCustomerFound.class })
    public ResponseEntity<ErrorResponse> orderNotFoundRequest(NoCustomerFound ex)
    {
		ErrorResponse err= new ErrorResponse(404, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err); 
    }

	
}
