package com.example.shop.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.shop.service.CatagoryService;

import net.minidev.json.JSONObject;

@RestController 
public class CatagoryController {
		
//	@Resource(name = "CatagoryServiceImpl")
//	private CatagoryService categoryService;
	@Autowired
	private CatagoryService catservice;
	
	
	//获得分类列表，responsebody将返回不代表路径，而是返回json数据放在body里
	 @RequestMapping("/catagory")
	 @ResponseBody
	    public JSONObject index() {
		    JSONObject json = new JSONObject();
		    
		    json.put("code",1);
		    json.put("data", catservice.getCategoryList());
		    
		   // categoryService.getProductCategoryList();
	        return json;
	    }
	 
	 
}
