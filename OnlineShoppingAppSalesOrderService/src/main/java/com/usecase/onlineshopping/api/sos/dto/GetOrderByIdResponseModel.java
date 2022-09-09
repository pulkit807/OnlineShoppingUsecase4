package com.usecase.onlineshopping.api.sos.dto;

import java.util.List;

public class GetOrderByIdResponseModel {
	private long id;
	private String orderDesc;
	private List<OrderLineItemDTO> orderLineItems;
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
	public List<OrderLineItemDTO> getOrderLineItems() {
		return orderLineItems;
	}
	public void setOrderLineItems(List<OrderLineItemDTO> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}
	
	
}
