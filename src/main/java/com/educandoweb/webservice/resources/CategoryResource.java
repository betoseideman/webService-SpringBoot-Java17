package com.educandoweb.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.webservice.entities.Category;
import com.educandoweb.webservice.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping //GET do HTTP
	public ResponseEntity<List<Category>> findAll(){         //TIPO QUE RETORNA RESPOSTAS
		List<Category> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value="/{id}") //PASSAR O VALOR DO ID, TERA UM PARAMETRO
	public ResponseEntity<Category> findById(@PathVariable Long id){ // PARA ACEITAR O PARAMENTRO COLOCAR ANOTAÇÃO
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}