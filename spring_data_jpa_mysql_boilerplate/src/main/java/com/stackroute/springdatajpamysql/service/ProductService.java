package com.stackroute.springdatajpamysql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.exceptions.ProductNotFoundException;

//Create service interface here

public interface ProductService {
    //Add abstract methods here
	public List<Product> getAllProducts();
	public Product getProductById(Long productId) throws ProductNotFoundException;
	public Product saveProduct(Product product);
	public Product updateProduct(Product updatedProduct, Long productId) throws ProductNotFoundException;
	public String deleteProduct(Long productId);
	public List<Product> getAllProductsHavingPriceLessThan(Double price);
}
