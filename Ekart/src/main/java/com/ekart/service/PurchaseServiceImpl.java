package com.ekart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.dao.CartRepository;
import com.ekart.dao.ItemRepository;
import com.ekart.model.Cart;
import com.ekart.model.Item;


@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired	
	ItemRepository itemRepo;
	
	@Autowired	
	CartRepository cartRepo;

	@Override
	public double costCalculation(List<Item> itemlist) {
		double totalCost = 0.0;		
		totalCost = itemlist.stream().mapToDouble(i -> i.getCost()*i.getQuantity())
        .reduce(0, (value1, value2) -> value1 + value2);  	 
		return totalCost;
	}

	@Override
	public Cart addCart(Cart cart) {
		cartRepo.save(cart);	 		
		return cart;
	}

	@Override
	public String deleteCart(long cartID) {
		cartRepo.deleteById( cartID);
		return "Cart is empty.. ";
	}

	
	

}
