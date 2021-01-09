package com.devsuperior.devsuperior.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.devsuperior.dto.OrderDTO;
import com.devsuperior.devsuperior.entities.Order;
import com.devsuperior.devsuperior.repositories.OrderRespository;

@Service
public class OrderServices {
	
	@Autowired
	private OrderRespository respository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = respository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

}
