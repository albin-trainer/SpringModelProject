package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.Order;
@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

}
