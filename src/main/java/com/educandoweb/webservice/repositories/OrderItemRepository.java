package com.educandoweb.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.webservice.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}	