package com.example.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shop.entity.ProductGroup;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {
	public ProductGroup findOne(long id);
}
