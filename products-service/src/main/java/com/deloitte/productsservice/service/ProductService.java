package com.deloitte.productsservice.service;

import java.util.List;

import com.deloitte.productsservice.model.Product;

public interface ProductService {
	
	Product addProduct(Product product);
	
	List<Product> getProductList();

}
