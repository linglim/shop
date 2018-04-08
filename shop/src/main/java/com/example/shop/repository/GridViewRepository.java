package com.example.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.shop.entity.Category;
import com.example.shop.entity.GridView;
import com.example.shop.entity.Indexconfig;
@RepositoryRestResource
public interface GridViewRepository extends JpaRepository<GridView, Long> {
	List<GridView>  findByIndexconfig(Indexconfig indexconfig);
	List<GridView>  findByIndexconfig(Long index_id);
	List<GridView> findByParentId(Long parent_id);
	
	List<GridView> findByIndexconfigAndParentId(Indexconfig index,long l);
}
