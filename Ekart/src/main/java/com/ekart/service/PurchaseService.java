package com.ekart.service;

import java.util.List;

import com.ekart.model.Cart;
import com.ekart.model.Item;

public interface PurchaseService {
	
	
	public Cart addCart(Cart cart) ;
	
	public double costCalculation(List<Item> itemlist);
	
	public String deleteCart(long cartid) ;

}
