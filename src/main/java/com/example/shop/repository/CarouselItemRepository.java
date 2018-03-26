package com.example.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.shop.entity.Authorization;
import com.example.shop.entity.CarouselItem;
import com.example.shop.entity.CarouselView;
@RepositoryRestResource
public interface CarouselItemRepository extends JpaRepository<CarouselItem, Long> {
	List<CarouselItem> findByCarouselView(CarouselView cv);
	List<CarouselItem> findByCarouselView(Integer car_id);
	
}
