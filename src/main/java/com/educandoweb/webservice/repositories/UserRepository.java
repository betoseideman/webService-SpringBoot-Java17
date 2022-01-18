package com.educandoweb.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.webservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}	