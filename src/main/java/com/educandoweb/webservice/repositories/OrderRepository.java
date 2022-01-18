package com.educandoweb.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.webservice.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}	