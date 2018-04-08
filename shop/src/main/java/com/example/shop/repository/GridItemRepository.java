package com.example.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.shop.entity.GridItem;
import com.example.shop.entity.GridView;
@RepositoryRestResource
public interface GridItemRepository extends JpaRepository<GridItem, Long> {

	
	List<GridItem> findByGridView(GridView grid);
	
	List<GridItem> findByGridView(Integer grid_id);
}
