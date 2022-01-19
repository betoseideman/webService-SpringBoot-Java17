package com.educandoweb.webservice.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.webservice.entities.User;
import com.educandoweb.webservice.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping //GET do HTTP  GET OBETM
	public ResponseEntity<List<User>> findAll(){         //TIPO QUE RETORNA RESPOSTAS
		List<User> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value="/{id}") //PASSAR O VALOR DO ID, TERA UM PARAMETRO
	public ResponseEntity<User> findById(@PathVariable Long id){ // PARA ACEITAR O PARAMENTRO COLOCAR ANOTAÇÃO
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping // POST CONFIGURA // SETAR // INSERIR
	public ResponseEntity<User> insert(@RequestBody User obj){ //  USAR A @ PARA DIZER QUE VAI CONVERTER DE JSON PARA uSER OO
		obj = service.insert(obj); //CRIAR UM URI PARA RETORNAR NO JSOM O 201 QUE SIGNIFICA CRIAÇÃO
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){		//TIPO VOID POIS O RETORNO SERA VAZIO
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}