package com.example.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.entity.Product;
import com.example.shop.repository.CategoryRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.ProductService;

import net.minidev.json.JSONArray;
@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository proRepo;
	
	@Override
	public JSONArray getProduct(int product_id) {
		// TODO Auto-generated method stub
		Product product = proRepo.getOne(product_id);
		
		return null;
	}

}
