package com.stackroute.springdatajpamysql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.exceptions.ProductNotFoundException;
import com.stackroute.springdatajpamysql.repository.ProductRepo;

//Implement ProductService here
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepo productRepo;

	// Override all the methods here
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public Product getProductById(Long productId) throws ProductNotFoundException {
		Optional<Product> product = productRepo.findById(productId);
		if (product.isPresent()) {
			return product.get();
		} else {
			throw new ProductNotFoundException("Id not found");
		}
	}

	public Product saveProduct(Product product) {
		Product savedProduct = productRepo.save(product);
		return savedProduct;
	}

	public Product updateProduct(Product updatedProduct, Long productId) throws ProductNotFoundException {
		Optional<Product> product = productRepo.findById(productId);
		if (product.isPresent()) {
			Product modifiedProduct = product.get();
			modifiedProduct.setName(updatedProduct.getName());
			modifiedProduct.setPrice(updatedProduct.getPrice());
			return productRepo.save(modifiedProduct);
		} else {
			throw new ProductNotFoundException("Id not found");
		}
	}

	public String deleteProduct(Long productId) {
		productRepo.deleteById(productId);
		return "Product Deleted";
	}
	
	public List<Product> getAllProductsHavingPriceLessThan(Double price) {
		return productRepo.findProductsLessThanPrice(price);
	}
	

}
