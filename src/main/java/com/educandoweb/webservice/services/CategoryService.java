package com.educandoweb.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.webservice.entities.Category;
import com.educandoweb.webservice.repositories.CategoryRepository;

@Service //REGISTRA A CLASSE COMO COMPONENTE DO SPRING
public class CategoryService {
	
	@Autowired
	private CategoryRepository repositoy;
	
	public List<Category> findAll(){
		return repositoy.findAll();
	}
	public Category findById(Long id) {
		Optional<Category> obj = repositoy.findById(id);
		return obj.get();
	}

}