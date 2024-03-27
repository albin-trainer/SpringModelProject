package com.cg.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.dao.OrderDao;
import com.cg.dao.ProductDao;
import com.cg.dto.OrderDTO;
import com.cg.model.Order;
import com.cg.model.Product;
import com.cg.secure.model.User;
import com.cg.secure.repository.UserRepository;
@Component
public class ShoppingServiceImpl implements ShoppingService {
	@Autowired
   private ProductDao prodDao;
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private UserRepository userRepo;
	@Override
	public Product addProduct(Product p) {
		return prodDao.save(p);
	}

	@Override
	public OrderDTO order(OrderDTO orderDto) {
		System.out.println("In service....");
		Product p=prodDao.findById(orderDto.getProdId()).get();
		User user=userRepo.findByUsername(orderDto.getUserName());
		
		Order order=new Order();
		order.setOrderDate(orderDto.getOrderDate());
		order.setP(p);//set product
		order.setUser(user);//set user
		orderDao.save(order);
		return orderDto;
	}

}
