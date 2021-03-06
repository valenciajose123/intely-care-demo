package com.ekart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.model.Cart;
import com.ekart.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>  {
	List<Item> findByName(String name);
	Optional<List<Item>>  findItemById(long itemId);
	

}
