package com.stackroute.productservice.test;
import com.stackroute.productservice.model.Product;
import com.stackroute.productservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class ProductServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProductInfo() {
        // Arrange
        int productId = 123;
        Product expectedProduct = new Product();
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(expectedProduct, HttpStatus.OK);

        Mockito.when(restTemplate.getForEntity(any(String.class), eq(Product.class), eq(productId)))
                .thenReturn(responseEntity);

        // Act
        Product actualProduct = productService.getProductInfo(productId);

        // Assert
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void testFallback() {
        // Arrange
        int productId = 123;
        Exception exception = new RuntimeException("Something went wrong");

        // Act
        Product fallbackProduct = productService.fallback(productId, exception);

        // Assert
        // Verify that the fallback method returns a Product object
        assertEquals(Product.class, fallbackProduct.getClass());
    }
}

