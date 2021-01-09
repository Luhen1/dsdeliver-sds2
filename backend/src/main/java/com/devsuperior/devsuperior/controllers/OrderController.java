package com.devsuperior.devsuperior.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.devsuperior.dto.OrderDTO;
import com.devsuperior.devsuperior.services.OrderServices;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderServices service;
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findall() {
		List<OrderDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
