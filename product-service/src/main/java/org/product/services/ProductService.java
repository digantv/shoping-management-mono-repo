package org.product.services;

import java.util.List;
import java.util.Optional;

import org.product.dto.ProductData;
import org.product.dto.ProductRequest;
import org.product.dto.ProductResponse;
import org.product.entity.Products;
import org.product.repo.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	List<Long> productIds;
	@Autowired
	ProductsRepository repo;

	public ProductResponse addProduct(ProductRequest request) {
		ProductResponse response = new ProductResponse();

		Products productTable = new Products();

		productTable.setProductName(request.getProductName());
		productTable.setPrice(request.getPrice());
		productTable.setQuantity(request.getQuantity());

		repo.save(productTable);

		response.setStatus("Success");
		response.setMessage("Product added successfully!!");
		response.setProductId(productTable.getProductId());

		return response;

	}

	public ProductResponse UpdateProduct(Long productId, ProductRequest request) {

		ProductResponse response = new ProductResponse();
		response.setProductData(new ProductData());
		Optional<Products> receivedData = repo.findById(productId);
		if (receivedData.isPresent()) {

			Products productTable = receivedData.get();

			productTable.setProductName(request.getProductName());
			productTable.setPrice(request.getPrice());
			productTable.setQuantity(request.getQuantity());
			productTable = repo.saveAndFlush(productTable);

			response.setStatus("Updated");
			response.setMessage("Product Updated");

			response.setProductId(productTable.getProductId());
			response.productData.setProductName(productTable.getProductName());
			response.productData.setPrice(productTable.getPrice());

		} else {
			response.setStatus("Error");
			response.setMessage("Product not found");
		}
		return response;
	}

	public ProductResponse deleteProduct(Long productId) {
		ProductResponse response = new ProductResponse();
		
		Optional<Products> receivedProduct = repo.findById(productId);

		if (receivedProduct.isPresent()) {
			repo.deleteById(productId);
			response.setStatus("Success");
			response.setMessage("Product deleted successfully");
		} else {
			response.setStatus("Error");
			response.setMessage("Product not found");
		}

		return response;
	}

	public ProductResponse getSingleProduct(Long productId) {

		ProductResponse response = new ProductResponse();
		response.setProductData(new ProductData());
		Optional<Products> receivedData = repo.findById(productId);

		if (!receivedData.isEmpty()) {
			Products product = receivedData.get();
			response.setStatus("Success");
			response.setMessage("Product found");
			response.setProductId(product.getProductId());
			response.productData.setProductName(product.getProductName());
			response.productData.setPrice(product.getPrice());
			response.productData.setQuantity(product.getQuantity());
		} else {
			response.setStatus("Error");
			response.setMessage("Product not found");
		}

		return response;
	}

	public List<Long> getAllProductIds() {
		List<Products> products = repo.findAll();

		for (Products product : products)
			productIds.add(product.getProductId());
		return productIds;
	}
}
