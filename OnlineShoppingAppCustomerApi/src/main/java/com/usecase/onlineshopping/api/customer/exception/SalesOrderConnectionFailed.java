package com.usecase.onlineshopping.api.customer.exception;

public class SalesOrderConnectionFailed extends  CustomException{
	private long custId;

	public SalesOrderConnectionFailed(String message,long custId) {
		super(message);
		this.custId=custId;
	}

	public long getCustId() {
		return custId;
	}
	
}