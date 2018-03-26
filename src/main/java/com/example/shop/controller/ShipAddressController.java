package com.example.shop.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.entity.Authorization;
import com.example.shop.repository.ShipAddressRepository;
import com.example.shop.repository.AuthorizationRepository;
import com.example.shop.service.CatagoryService;
import com.example.shop.service.ShipAddressService;
import com.example.shop.service.UserService;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;



@RestController 
public class ShipAddressController {
		
	@Autowired
	private ShipAddressRepository shipRepo;
	
	@Autowired
	private AuthorizationRepository auRepo;
	
    @Resource
    ShipAddressService shipService;
	
	//获得配送信息列表，responsebody将返回不代表路径，而是返回json数据放在body里
	 
	 @RequestMapping(value = "/ship_address/access_token={access_token}",method = RequestMethod.POST)
	 @ResponseBody
	    public JSONObject index(@PathVariable String access_token) {
		    JSONObject json = new JSONObject();
		    
		    json.put("code",1);
		    JSONArray obj = shipService.getShipAddressArray(access_token);
		    for(Object it : obj){
		    	System.out.println(it);
		    }
		    
			json.put("data",shipService.getShipAddressArray(access_token));
		   // json.put("data", auRepo.findByAccessToken(access_token));
		    
		   // categoryService.getProductCategoryList();
	        return json;
	    }
	 
	 
}