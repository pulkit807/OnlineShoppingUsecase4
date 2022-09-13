package com.usecase.onlineshopping.api.sos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SaleOrderControllerAdvice {
	@ExceptionHandler(value = { CustomerNotFound.class })
    public ResponseEntity<ErrorResponse> customerNotFoundRequest(CustomerNotFound ex)
    {
		ErrorResponse err= new ErrorResponse(400, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err); 
    }
	
	@ExceptionHandler(value = { ItemsNotFound.class })
    public ResponseEntity<ErrorResponse> itemsNotFoundRequest(ItemsNotFound ex)
    {
		ErrorResponse err= new ErrorResponse(400, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err); 
    }
	
	@ExceptionHandler(value = { OrderNotFound.class })
    public ResponseEntity<ErrorResponse> orderNotFoundRequest(OrderNotFound ex)
    {
		ErrorResponse err= new ErrorResponse(404, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err); 
    }

	
}
