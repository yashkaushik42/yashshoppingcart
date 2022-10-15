package com.deloitte.productsservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.productsservice.model.Product;
import com.deloitte.productsservice.model.UserLogin;
import com.deloitte.productsservice.service.ProductServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.HttpHeaders;

import ch.qos.logback.core.net.ObjectWriter;


@RestController
@RequestMapping
public class ProductController {
	
	@Autowired
	private ProductServiceImp productService;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		
		Product p;
		try {
			p = productService.addProduct(product);
		}catch(Exception e) {
			p = new Product( "Invalid", product.getPrice());
		}
		
		return p;
	}
	
	
	
	@PostMapping("/getProductList")
	public List<Product> getProductList(@RequestBody UserLogin userLogin){
	org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper mapper = new ObjectMapper();
		String requestJson;
		ResponseEntity<Boolean> response;
		try {
			requestJson = mapper.writeValueAsString(userLogin);
			org.springframework.http.HttpEntity<String> request = new org.springframework.http.HttpEntity<>(requestJson,headers);
			
			String url = "http://localhost:9192/login";
			 response = restTemplate.postForEntity(url, request, Boolean.class);
			
			 if(response.getBody()) {
				 return this.productService.getProductList();
			 }
		
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Product product = new Product("Login failed", 0.0);
		List<Product> productList  = new ArrayList<>();
		productList.add(product);
		
		return  productList;
		
		
		
	}
	
}
