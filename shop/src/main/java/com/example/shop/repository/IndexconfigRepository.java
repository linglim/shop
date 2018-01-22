package com.example.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.shop.entity.Indexconfig;









@RepositoryRestResource(path = "config")
public interface IndexconfigRepository extends JpaRepository<Indexconfig, Integer> {
//	Indexconfig findByInteger(Integer id);
	
	//@Query("select i from Indexconfig i where i.id=(select max(p2.id) from Indexconfig p2)")
	//Indexconfig findMaxIdIndexconfig();
	
	public Indexconfig findTopByOrderByIdAsc();
	public Indexconfig findByRato(float ratio);
	
	
}
