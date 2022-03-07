package com.ekart;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ekart.controller.ItemController;

@SpringBootTest

class EkartApplicationTests {
	
	 @Autowired
	private ItemController controller;
	    
	    
	    
	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
