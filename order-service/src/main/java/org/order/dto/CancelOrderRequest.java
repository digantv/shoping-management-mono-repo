package org.order.dto;

import org.springframework.stereotype.Component;

@Component
public class CancelOrderRequest {
	private Long orderId;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
