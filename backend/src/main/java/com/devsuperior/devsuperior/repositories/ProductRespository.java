package com.devsuperior.devsuperior.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.devsuperior.entities.Product;

public interface ProductRespository extends JpaRepository<Product, Long>{

	List<Product> findAllByOrderByNameAsc();
}
