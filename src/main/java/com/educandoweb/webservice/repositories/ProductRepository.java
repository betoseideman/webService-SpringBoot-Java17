package com.educandoweb.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.webservice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}	