package com.educandoweb.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.webservice.entities.User;
import com.educandoweb.webservice.repositories.UserRepository;

@Service //REGISTRA A CLASSE COMO COMPONENTE DO SPRING
public class UserService {
	
	@Autowired
	private UserRepository repositoy;
	
	public List<User> findAll(){
		return repositoy.findAll();
	}
	public User findById(Long id) {
		Optional<User> obj = repositoy.findById(id);
		return obj.get();
	}
	public User insert(User obj) {
		return repositoy.save(obj);
	}
	public void delete(Long id) {
		repositoy.deleteById(id);
	}

}