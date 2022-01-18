package com.educandoweb.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.webservice.entities.Order;
import com.educandoweb.webservice.repositories.OrderRepository;

@Service //REGISTRA A CLASSE COMO COMPONENTE DO SPRING
public class OrderService {
	
	@Autowired
	private OrderRepository repositoy;
	
	public List<Order> findAll(){
		return repositoy.findAll();
	}
	public Order findById(Long id) {
		Optional<Order> obj = repositoy.findById(id);
		return obj.get();
	}

}