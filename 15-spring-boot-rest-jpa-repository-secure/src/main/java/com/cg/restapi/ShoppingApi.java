package com.cg.restapi;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.OrderDTO;
import com.cg.model.Product;
import com.cg.service.ShoppingService;
@RestController
@RequestMapping("/products")
public class ShoppingApi {
	
	@Autowired
	private ShoppingService shoppingService;
    @PostMapping
	public Product addProduct(@RequestBody Product p) {
		return shoppingService.addProduct(p);
	}
    
    @PostMapping("/order")
   	public OrderDTO order(@RequestBody OrderDTO orderDto,Principal p) {
    	System.out.println("In orders....api");
    	System.out.println(p.getName());
    	orderDto.setUserName(p.getName());
    	
    	shoppingService.order(orderDto);
   		return orderDto;
   	}
}
