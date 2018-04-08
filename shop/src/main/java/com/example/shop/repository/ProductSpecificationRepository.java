package com.example.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shop.entity.ProductSpecification;

public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification, Long> {
	
	List<ProductSpecification> findByProduct(long id);
}
