package com.usecase.onlineshopping.api.sos.dto;

public class GetOrderByCustIdResponseModel {

	private long id;

	private String orderDesc;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

}
