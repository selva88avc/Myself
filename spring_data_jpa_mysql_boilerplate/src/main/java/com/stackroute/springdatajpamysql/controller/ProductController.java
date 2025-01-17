package com.stackroute.springdatajpamysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    // Add controllers here for CRUD operations on Product entity.
	@Autowired
	ProductService productService;
	
	@GetMapping("/view")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@GetMapping("/view/product")
	public ResponseEntity<Product> getProductById(@RequestParam Long productId){
		Product product = productService.getProductById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		Product savedProduct = productService.saveProduct(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
		
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable("id") Long id){
		Product savedProduct = productService.updateProduct(product,id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) 
	{		
		String res=productService.deleteProduct(id);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> getAllProductsHavingPriceLessThan(@RequestParam Double price) {
		List<Product> products = productService.getAllProductsHavingPriceLessThan(price);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

}
