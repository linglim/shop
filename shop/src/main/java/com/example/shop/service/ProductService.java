package com.example.shop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.shop.entity.Product;
import com.example.shop.entity.ProductGroup;
import com.example.shop.entity.ProductSpecification;
import com.example.shop.entity.Shop;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public interface ProductService {

	/**
	 * 查找商品
	 * 
	 * @return 商品
	 */
    public JSONObject getProduct(long id);
    
    public List<Product> findAll();
    
    public void saveUser(Product product);
    
    public Product findOne(long id);

    public void delete(long id);

    public List<Product> findByName(String name);
   
    public ProductGroup findPG(long gid);
    
    public JSONObject getComment(Product product);

    
    public Shop findShop(long s_id);
    //通过商品id获得商品参数
    public JSONArray findPS(long p_id);
  //通过商品组id获得商品组参数
    public JSONArray findGPS(long g_id);
    
 
   // public Category findCategoryById(int id);
}
