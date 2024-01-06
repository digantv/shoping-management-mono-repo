package org.order.controller;

import org.order.dto.CancelOrderResponse;
import org.order.dto.PlaceOrderRequest;
import org.order.dto.PlaceOrderResponse;
import org.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


	@Autowired
	OrderService orderServices;
	
	@PostMapping(path = "/api/v1/order")
	public PlaceOrderResponse orderService(@RequestBody PlaceOrderRequest orderRequest) {
		return orderServices.placeOrder(orderRequest);
			
	}
	@DeleteMapping(path="/api/v1/order/{orderId}")
	public CancelOrderResponse cancelOrder(@PathVariable Long orderId) {
		return orderServices.cancelOrder(orderId);
	}
}
