package com.devsuperior.devsuperior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.devsuperior.entities.Order;

public interface OrderRespository extends JpaRepository<Order, Long>{

}
