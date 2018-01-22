package com.example.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.repository.ProductRepository;
import com.example.shop.service.CatagoryService;
import com.example.shop.service.ProductService;

import net.minidev.json.JSONObject;

@RestController 
public class ProductController {
		
//	@Resource(name = "CatagoryServiceImpl")
//	private CatagoryService categoryService;
	@Autowired
	private ProductService proservice;
	@Autowired
	private ProductRepository proRepo;
	
	/**
	 * @param id
	 * 接口2： 通过商品id取得商品
	 * */
	 
	 @RequestMapping(value = "/product/{id}")
	 @ResponseBody
	    public JSONObject getProduct(@PathVariable Integer id) {
		    JSONObject json = new JSONObject();
		    
		    json.put("code",1);
		    json.put("data", proRepo.findById(id));
		    
		   // categoryService.getProductCategoryList();
	        return json;
	    }
	 
		/**
		 * @param id
		 * 接口26：获取商品id
		 * */
	 @RequestMapping(value = "/product/")
	 @ResponseBody
	    public JSONObject index(@PathVariable Integer id) {
		    JSONObject json = new JSONObject();
		    
		    json.put("code",1);
		    json.put("data", proRepo.findById(id));
		    
		   // categoryService.getProductCategoryList();
	        return json;
	    }
	 
	 /**
		 * @param id
		 * 接口3： 商品评论列表
		 * /product/{id}/comment
		 * */
		 
		 @RequestMapping(value = "/product/{id}/comment")
		 @ResponseBody
		    public JSONObject getComment(@PathVariable Integer id) {
			    JSONObject json = new JSONObject();
			    
			    json.put("code",1);
			    json.put("data", proRepo.findById(id));
			    
			   // categoryService.getProductCategoryList();
		        return json;
		    }
	 
		 /**
			 * @param id
			 * 接口4： 添加商品评论
			 * /product/{id}/comment
			 * */
			 
			 @RequestMapping(value = "/product/{id}/comment/add")
			 @ResponseBody
			    public JSONObject AddComment(@PathVariable Integer id) {
				    JSONObject json = new JSONObject();
				    
				    json.put("code",1);
				    json.put("data", proRepo.findById(id));
				    
				   // categoryService.getProductCategoryList();
			        return json;
			    }
	 
	 
	 
	 
		/**
		 * 通过商品id取得商品
		 * */
	 @RequestMapping(value = "/product_feature?product_id={product_id}")
	 @ResponseBody
	    public JSONObject getfeature(@PathVariable Integer product_id) {
		    JSONObject json = new JSONObject();
		    
		    json.put("code",1);
		    json.put("data", proRepo.findById(product_id));
		    
		   // categoryService.getProductCategoryList();
	        return json;
	    }
	 
	 
}
