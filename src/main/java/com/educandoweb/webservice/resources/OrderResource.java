package com.educandoweb.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.webservice.entities.Order;
import com.educandoweb.webservice.services.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping //GET do HTTP
	public ResponseEntity<List<Order>> findAll(){         //TIPO QUE RETORNA RESPOSTAS
		List<Order> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value="/{id}") //PASSAR O VALOR DO ID, TERA UM PARAMETRO
	public ResponseEntity<Order> findById(@PathVariable Long id){ // PARA ACEITAR O PARAMENTRO COLOCAR ANOTAÇÃO
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}