package com.example.shop.service.impl;

import java.util.List;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.shop.entity.ShipAddress;
import com.example.shop.entity.User;
import com.example.shop.repository.AuthorizationRepository;
//import com.example.shop.repository.ProductCategoryRepository;
import com.example.shop.repository.ShipAddressRepository;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.CatagoryService;
import com.example.shop.service.ShipAddressService;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Service("shipAddressServiceImpl")
public  class ShipAddressServiceImpl implements ShipAddressService {
	@Autowired
    private UserRepository userRepo;
	
	@Autowired
    private ShipAddressRepository shipRepo;
	
	@Autowired
    private AuthorizationRepository authRepo;
	
    @Transactional(readOnly = true)
    
    
    /**
     * 
     * 
     * 获得默认地址
     * */
    public JSONObject getDefaultAddressArray(String access_token){
    	JSONObject obj = new JSONObject();
    	Integer user_id = getUserId(access_token);
    	ShipAddress add = getDefaultAddress(user_id);
    	obj.put("id", add.getId());
		obj.put("receiver_name", add.getReceiverName());
		obj.put("receiver_phone", add.getReceiverPhone());
		obj.put("province", add.getProvince());
		obj.put("city", add.getCity());
		obj.put("detail", add.getDetail());
    	
    	return obj;
    	
    }
    
    

    public List<ShipAddress> getShipAddress(String access_token){
    	/** 先注释掉权限检查，token是否合法*/
    //	Boolean is_active = authRepo.isAvilable();
    //	if(is_active != null || is_active){
    		Integer user_id = getUserId(access_token);
    		return getShipAddress(user_id);
    //	}
	//	return null;
    	
    }
    
    
    
    public JSONArray getShipAddressArray(String access_token){
    	//Boolean is_active = checkToken();
    	Integer user_id = getUserId(access_token);
		JSONArray array = new JSONArray();
		List<ShipAddress> list = getShipAddress(user_id);
		for(ShipAddress add : list){
			JSONObject obj = new JSONObject();
			obj.put("id", add.getId());
			obj.put("receiver_name", add.getReceiverName());
			obj.put("receiver_phone", add.getReceiverPhone());
			obj.put("province", add.getProvince());
			obj.put("city", add.getCity());
			obj.put("detail", add.getDetail());
			
			array.add(obj);
		}
    	return array;
    }
    
	public List<ShipAddress> getShipAddress(Integer user_id){
    	//Boolean is_active = checkToken();
    	List<ShipAddress> list = shipRepo.findByUserId(user_id);
    	return list;
    }
    
	public ShipAddress getDefaultAddress(Integer user_id){
		Integer is_default = 1;
		return shipRepo.findByUserIdAndIsDefault(user_id,is_default);
	}
	
	
	public Integer getUserId(String access_token){
        
		User user = authRepo.getByAccessToken(access_token).getUser();
	    return user.getId();
	//	return null;
	    
	}
	
	//鉴权待实现
	//public Boolean checkTocken(String access_token);
    

	
		
		

    
}
