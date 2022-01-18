package com.educandoweb.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.webservice.entities.Product;
import com.educandoweb.webservice.repositories.ProductRepository;

@Service //REGISTRA A CLASSE COMO COMPONENTE DO SPRING
public class ProductService {
	
	@Autowired
	private ProductRepository repositoy;
	
	public List<Product> findAll(){
		return repositoy.findAll();
	}
	public Product findById(Long id) {
		Optional<Product> obj = repositoy.findById(id);
		return obj.get();
	}

}