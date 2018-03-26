package com.example.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.shop.entity.Comment;
import com.example.shop.entity.Product;



public interface CommentRepository extends JpaRepository<Comment, Long>  {

	List<Comment> findById(long id);
	List<Comment> findByProduct(Product product);

	//List<Product> findByName(String name);
	//Product findById(long id);
	//public Product findOne(long id);
	
	

}