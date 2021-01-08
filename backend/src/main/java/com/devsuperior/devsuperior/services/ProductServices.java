package com.devsuperior.devsuperior.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.devsuperior.dto.ProductDTO;
import com.devsuperior.devsuperior.entities.Product;
import com.devsuperior.devsuperior.repositories.ProductRespository;

@Service
public class ProductServices {
	
	@Autowired
	private ProductRespository respository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		List<Product> list = respository.findAllByOrderByNameAsc();
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}

}
