package com.stackroute.productservice.controller;

import com.stackroute.productservice.model.Product;
import com.stackroute.productservice.repository.ProductRepository;
import com.stackroute.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Handle errors and return appropriate response entity
    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductInfo(@PathVariable int productId) {
        Product product = productService.getProductInfo(productId);
        if(product!=null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        } else {
            return new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
        }
    }
}
