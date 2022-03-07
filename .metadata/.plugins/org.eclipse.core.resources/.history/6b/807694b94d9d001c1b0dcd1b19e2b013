package com.ekart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.model.Cart;



@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
	
	public Cart findByCartId(int cartId);

}
