package com.example.shop.service;

import com.example.shop.entity.Product;

import net.minidev.json.JSONArray;

public interface ProductService {

	/**
	 * 查找商品分类
	 * 
	 * @return 商品分类列表
	 */
    public JSONArray getProduct(int product_id);
 
   // public Category findCategoryById(int id);
}
