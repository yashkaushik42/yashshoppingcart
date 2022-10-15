package com.deloitte.productsservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.productsservice.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

	
}
