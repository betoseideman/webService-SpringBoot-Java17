package com.educandoweb.webservice.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.webservice.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping //GET do HTTP
	public ResponseEntity<User> findAll(){         //TIPO QUE RETORNA RESPOSTAS
		User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "123466");
		return ResponseEntity.ok().body(u);
	}

}