package com.example.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.shop.entity.Product;
import com.example.shop.entity.User;
import com.example.shop.entity.Category;
@RepositoryRestResource(path = "product")
public interface ProductRepository extends JpaRepository<Product, Long>  {

	List<Product> findByName(String name);
	//Product findById(long id);
	Product findOne(long id);
	

}
