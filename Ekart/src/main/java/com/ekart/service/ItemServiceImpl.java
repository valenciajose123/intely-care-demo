package com.ekart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.dao.ItemRepository;
import com.ekart.model.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired	
	ItemRepository itemRepo;
	
	
	@Override
	public Item addItem(Item item) {	
		itemRepo.save(item);	 		
		return item;
	}


	@Override
	public String deleteItem(long itemid) {			
		itemRepo.deleteById(itemid);
		return "Removed product from cart";
	}


	@Override
	public Optional<List<Item>> fetchItemById(int itemId) {
		return itemRepo.findItemById( itemId);
	}


	
		



}
