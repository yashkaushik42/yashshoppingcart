package com.deloitte.productsservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.productsservice.model.Product;
import com.deloitte.productsservice.repository.ProductRepo;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}
	
	

}
