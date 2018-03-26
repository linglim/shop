package com.example.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//import com.example.shop.entity.Product;
//import com.example.shop.entity.ProductCategory;
import com.example.shop.entity.ShipAddress;
import com.example.shop.entity.User;

import net.minidev.json.JSONArray;

//@RepositoryRestResource(collectionResourceRel = "data",path = "ship_address")
@RepositoryRestResource(path = "user/shipaddress")
public interface ShipAddressRepository  extends JpaRepository<ShipAddress, Long> {
	/**
	 * 查找配送
	 * 
	 * @return 通过user_id配送地址列表
	 */
   
    List<ShipAddress> findByUserId(Integer access_token);

	ShipAddress findByUserIdAndIsDefault(long user_id, Integer is_default);
	

}
