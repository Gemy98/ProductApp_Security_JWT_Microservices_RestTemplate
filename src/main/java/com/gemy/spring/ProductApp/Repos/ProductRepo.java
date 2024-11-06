package com.gemy.spring.ProductApp.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gemy.spring.ProductApp.Model.Product;


public interface ProductRepo extends JpaRepository<Product, Long> {

//	Product findById(long id);

	
}
