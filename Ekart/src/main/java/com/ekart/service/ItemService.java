package com.ekart.service;

import java.util.List;
import java.util.Optional;

import com.ekart.model.Item;

public interface ItemService {
	
	public Item addItem(Item item) ;
	
	public String deleteItem(long itemid) ;
	
	public Optional<List<Item>> fetchItemById(int itemId) ;
	
	

}
