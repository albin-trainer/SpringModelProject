package com.cg.service;

import com.cg.dto.OrderDTO;
import com.cg.model.Product;

public interface ShoppingService {
 Product addProduct(Product p);
 OrderDTO order(OrderDTO orderDto);
}
