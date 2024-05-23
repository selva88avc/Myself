package com.stackroute.productservice.test;

import com.stackroute.productservice.controller.ProductController;
import com.stackroute.productservice.model.Product;
import com.stackroute.productservice.repository.ProductRepository;
import com.stackroute.productservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProductInfo_Success() {
        // Arrange
        int productId = 123;
        Product expectedProduct = new Product();
        ResponseEntity<Product> expectedResponseEntity = new ResponseEntity<>(expectedProduct, HttpStatus.OK);

        when(repository.findById(anyInt())).thenReturn(Optional.of(expectedProduct));
        when(productService.getProductInfo(productId)).thenReturn(expectedProduct);

        // Act
        ResponseEntity<?> actualResponseEntity = productController.getProductInfo(productId);

        // Assert
        assertEquals(expectedResponseEntity.getStatusCode(), actualResponseEntity.getStatusCode());
        assertEquals(expectedResponseEntity.getBody(), actualResponseEntity.getBody());
    }

    @Test
    void testGetProductInfo_ProductNotFound() {
        // Arrange
        int productId = 456;

        when(repository.findById(anyInt())).thenReturn(Optional.empty());

        // Act
        ResponseEntity<?> actualResponseEntity = productController.getProductInfo(productId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, actualResponseEntity.getStatusCode());
        assertEquals(null, actualResponseEntity.getBody());
    }


}
