package com.devsuperior.devsuperior.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.devsuperior.dto.OrderDTO;
import com.devsuperior.devsuperior.dto.ProductDTO;
import com.devsuperior.devsuperior.entities.Order;
import com.devsuperior.devsuperior.entities.OrderStatus;
import com.devsuperior.devsuperior.entities.Product;
import com.devsuperior.devsuperior.repositories.OrderRespository;
import com.devsuperior.devsuperior.repositories.ProductRespository;

@Service
public class OrderServices {
	
	@Autowired
	private OrderRespository respository;
	
	@Autowired
	private ProductRespository productRespository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = respository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

	@Transactional 
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), 
				Instant.now(), OrderStatus.PENDING);
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRespository.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = respository.save(order);
		return new OrderDTO(order);
	}
	
	@Transactional 
	public OrderDTO setDelivered(Long id) {
		 Order order = respository.getOne(id);
		 order.setStatus(OrderStatus.DELIVERED);
		 order = respository.save(order);
		 return new OrderDTO(order);
	}
}
