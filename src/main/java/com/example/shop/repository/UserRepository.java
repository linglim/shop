package com.example.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.shop.entity.User;

@RepositoryRestResource(path = "user")
public interface UserRepository
 extends JpaRepository<User, Long> {
	User findById(long id);
    Long deleteById(Integer id);
   // public Integer getUserId(String access_token);
    User findByNameAndPassword(String name, String password);
	User findByName(String name);
}