package com.example.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.service.CatagoryService;
import com.example.shop.service.IndexService;

import net.minidev.json.JSONObject;

@RestController 
public class IndexController {
	@Autowired
	private IndexService indexservice;
	//获得首页列表，responsebody将返回不代表路径，而是返回json数据放在body里
		 @RequestMapping("/homepage")
		 @ResponseBody
		    public JSONObject index() {
			    JSONObject json = new JSONObject();
			    
			    json.put("code",1);
			    json.put("data", indexservice.getRowsArray());
			    
			   // categoryService.getProductCategoryList();
		        return json;
		    }
}
