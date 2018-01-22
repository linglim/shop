package com.example.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.shop.entity.CarouselView;
import com.example.shop.entity.Indexconfig;
@RepositoryRestResource
public interface CarouselViewRepository extends JpaRepository<CarouselView, Integer> {

	List<CarouselView> findByIndexconfig(Indexconfig indexconfig);
	List<CarouselView> findByIndexconfig(Integer indexconfig_id);
}
