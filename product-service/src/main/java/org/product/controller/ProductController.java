package org.product.controller;

import java.util.List;

import org.product.dto.ProductRequest;
import org.product.dto.ProductResponse;
import org.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping(path = "/api/v1/product", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ProductResponse addproductDetails(@RequestBody ProductRequest request) {
		return service.addProduct(request);
	}

	@PutMapping(path = "/api/v1/product/{productId}", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ProductResponse UpdateProduct(@PathVariable Long productId, @RequestBody ProductRequest request) {
		return service.UpdateProduct(productId, request);
	}

	@DeleteMapping(path = "/api/v1/product/{productId}", consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public ProductResponse deleteProduct(@PathVariable Long productId) {
		return service.deleteProduct(productId);
	}

	@GetMapping(path = "/api/v1/product/{productId}", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ProductResponse searchProduct(@PathVariable Long productId) {
		return service.getSingleProduct(productId);
	}
	@GetMapping(path = "/api/v1/product", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public List<Long> getAllProductId() {
		return service.getAllProductIds();
	}
}
