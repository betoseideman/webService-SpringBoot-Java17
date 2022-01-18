package com.educandoweb.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.webservice.entities.Product;
import com.educandoweb.webservice.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping //GET do HTTP
	public ResponseEntity<List<Product>> findAll(){         //TIPO QUE RETORNA RESPOSTAS
		List<Product> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value="/{id}") //PASSAR O VALOR DO ID, TERA UM PARAMETRO
	public ResponseEntity<Product> findById(@PathVariable Long id){ // PARA ACEITAR O PARAMENTRO COLOCAR ANOTAÇÃO
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}