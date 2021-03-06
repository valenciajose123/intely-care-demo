package com.ekart.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.dao.ItemRepository;
import com.ekart.model.Cart;
import com.ekart.model.Item;
import com.ekart.service.ItemService;
import com.ekart.service.PurchaseService;

import java.util.Optional;


@RestController
@Validated
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	PurchaseService purchaseService;
	
	Logger logger = LoggerFactory.getLogger(ItemController.class); 
	
	@GetMapping("/")
	public List<Item> getCarts(){		
		logger.info("-- Fetching all the items --");
		List<Item> items = itemRepository.findAll();		
		return items;
	}
	
	
	@GetMapping("/fetchItem/{id}")
	public ResponseEntity<?> getItemById(@PathVariable("id") int id) {
		Optional<Item> itemData = itemRepository.findById((long) id);
		logger.info("-- Fetching item as per ID --");
		
		if (itemData.isPresent()) {
			return new ResponseEntity<>(itemData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Item is not present in the cart",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/additem") 
	public ResponseEntity<?> addToCart( @RequestBody Item item) {	
		logger.info("-- Adding product to cart --");
		itemService.addItem(item);		
		logger.info("-- Added product to cart --");
		return new ResponseEntity<String>("Item added to cart",HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteitem/{itemid}")
	public ResponseEntity<?> removeFromCart(@PathVariable("itemid") long itemid ) {	
		logger.info("-- Removing item --");
		itemService.deleteItem(itemid);
		logger.info("-- Item removed --");
		return new ResponseEntity<String>("Removed item from cart",HttpStatus.OK);
		
	}
	
	@GetMapping("/displaycost")
	public ResponseEntity<?> displayCartCost() {	
		logger.info("-- Displaying the cost of all the products --");
		List<Item> items = itemRepository.findAll();
		double cost= purchaseService.costCalculation(items)	;
		cost=cost+0.04*cost;
		return new ResponseEntity<String>("The total cost of cart along with tax of 4% is "+cost,HttpStatus.OK);
		
	}
	
	@PostMapping("/createCart") 
	public ResponseEntity<?> createCart( @RequestBody Cart cart) {	
		logger.info("-- Creating cart --");
		purchaseService.addCart(cart);		
		logger.info("-- Cart created --");
		return new ResponseEntity<String>("Cart created",HttpStatus.OK);
	}
	
	
	@GetMapping("/purchaseCart/{cartid}")
	public ResponseEntity<?> purchaseCart(@PathVariable("cartid") long cartid) {
		logger.info("-- Purchasing the cart items --");
		List<Item> itemData = itemRepository.findAll();
		itemRepository.deleteAll();
		logger.info("-- Purchase all the cart items --");
	
		logger.info("-- Cart purchased --");
		return new ResponseEntity<String>("Shopping successful",HttpStatus.OK);
		
	}
	
	
}
