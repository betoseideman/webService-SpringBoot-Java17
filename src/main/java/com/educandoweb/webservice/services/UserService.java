package com.educandoweb.webservice.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.webservice.entities.User;
import com.educandoweb.webservice.repositories.UserRepository;
import com.educandoweb.webservice.services.exceptions.DatabaseException;
import com.educandoweb.webservice.services.exceptions.ResourceNotFoundException;

@Service //REGISTRA A CLASSE COMO COMPONENTE DO SPRING
public class UserService {
	
	@Autowired
	private UserRepository repositoy;
	
	public List<User> findAll(){
		return repositoy.findAll();
	}
	public User findById(Long id) {
		Optional<User> obj = repositoy.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id) );
	}
	public User insert(User obj) {
		return repositoy.save(obj);
	}
	public void delete(Long id) {
		try {
			repositoy.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) { // NOME DA EXCEÇÃO PEGO COM RUM TIME EXCEPTION
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	public User update(Long id, User obj) {
		try {
			User entity = repositoy.getById(id);		
			updateData(entity, obj);
			return repositoy.save(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}

}