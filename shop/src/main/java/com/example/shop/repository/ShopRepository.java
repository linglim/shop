package com.example.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shop.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {

}
