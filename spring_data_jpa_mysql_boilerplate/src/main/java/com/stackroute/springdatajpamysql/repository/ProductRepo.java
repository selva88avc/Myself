package com.stackroute.springdatajpamysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.springdatajpamysql.entity.Product;

//Create ProductRepo interface extending JpaRepository
public interface ProductRepo extends JpaRepository<Product, Long>{

	List<Product> findProductsLessThanPrice(Double price);
}
