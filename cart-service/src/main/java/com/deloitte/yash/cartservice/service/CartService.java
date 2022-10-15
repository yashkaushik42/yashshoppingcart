package com.deloitte.yash.cartservice.service;

import java.util.List;

import com.deloitte.yash.cartservice.model.Cart;

public interface CartService {
	
	Cart addItemToCart(Cart cartItem);
	List<Cart> getUserCartItems(String username);

}
