/**
 * 
 */
package com.example.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.shop.entity.Category;

/**
 * @author lenovo
 *
 */
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
	List<Category> findByParentId(Long parent_id);
}
