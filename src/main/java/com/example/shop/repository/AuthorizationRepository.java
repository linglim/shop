package com.example.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.shop.entity.Authorization;
//import com.example.shop.entity.ProductCategory;
import com.example.shop.entity.ShipAddress;

@RepositoryRestResource
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {
   // List<Authorization> findByAccessToken(String access_token);

    Authorization getOne(Long id);

	

	//Boolean isAvilable();

	
    
}
