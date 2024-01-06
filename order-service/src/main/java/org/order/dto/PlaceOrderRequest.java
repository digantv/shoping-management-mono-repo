package org.order.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PlaceOrderRequest {

	private List<Long> productIds;
    private int quantity;

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



}
