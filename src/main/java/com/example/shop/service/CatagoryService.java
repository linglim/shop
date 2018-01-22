package com.example.shop.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.shop.entity.Category;
import com.example.shop.repository.CategoryRepository;

import net.minidev.json.JSONArray;


public interface CatagoryService {
	

	/**
	 * 查找商品分类
	 * 
	 * @return 商品分类列表
	 */
    public JSONArray getCategoryList();
 
    public Category findCategoryById(int id);

//    public void save(Category cata);
//
//    public void edit(Category cata);
//
//    public void delete(int id);
    
    

}
