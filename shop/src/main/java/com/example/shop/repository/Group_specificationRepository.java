package com.example.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shop.entity.Group_specification;
import com.example.shop.entity.ProductSpecification;

public interface Group_specificationRepository extends JpaRepository<Group_specification, Long> {
	//List<Group_specification> findByProductID(long id);

	List<Group_specification> findByProductGroup(long g_id);
}
