package com.ekart.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    @Column(name = "user_id")
    private String userId;
    
    @Column(name = "created_date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date createdDate;
 
   
	@OneToMany(cascade = CascadeType.MERGE,mappedBy = "cart",fetch = FetchType.LAZY)
	private List<Item> item; 
    
    public Cart() {
    }

	public Cart(long cartId, String userId, Date createdDate, List<Item> item) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.createdDate = createdDate;
		this.item = item;
	}

	

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@JsonManagedReference
	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", createdDate=" + createdDate + ", item=" + item + "]";
	}
    
    



}
