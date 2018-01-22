package com.example.shop.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.entity.Authorization;
import com.example.shop.entity.User;
import com.example.shop.repository.AuthorizationRepository;
import com.example.shop.repository.ShipAddressRepository;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.ShipAddressService;
import com.example.shop.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;
	
	@Autowired
	private ShipAddressRepository shipRepo;
	
	@Autowired
	private AuthorizationRepository auRepo;
	
	
	@Autowired
	private UserRepository userRepo;
	
	@Resource
	ShipAddressService shipService;
 
//
//    @RequestMapping("/")
//    public String index() {
//        return "redirect:/list";
//    }
	/**
	 * 11：用户默认收货地址(over)
	 * /user/shipaddress/default
	 * 
	 * */
    @RequestMapping(value = "/shipaddress/default/{access_token}")
    public JSONObject DefaultAddress(@PathVariable String access_token) {
    	JSONObject json = new JSONObject();
    	json.put("code",1);	    
		json.put("data",shipService.getDefaultAddressArray(access_token));
        return json;
    }
	
	
    
	/**
	 * 10：用户收货地址列表（over）
	 * /user/shipaddress/
	 * @param access_token
	 * 
	 * */
    @RequestMapping(value = "/shipaddress/access_token={access_token}")
    public JSONObject Addresslist(@PathVariable String access_token) {
    	 JSONObject json = new JSONObject();
		    
	     json.put("code",1);
		 json.put("data",shipService.getShipAddressArray(access_token));
         return json;
    }

	/**
	 *  12.添加用户收货地址(缺数据格式，有没有code:1)
	 * 
      /user/shipaddress/add
       access_token: 访问令牌
	 * /user/shipaddress/
	 * @param access_token
	 * @param Request
	 * post
	 * 在ship.repo里实现
	 * 
	 * 
	 *  13.删除用户收货地址
	 *  /user/shipaddress/{id}/delete
	 *  在ship.repo
	 * */
    
    /**
     * 14.发送验证短信(不明确参数和数据类型)
     * /user/sms/send
     * phone:手机号
     * */
    
//    @RequestMapping("/sms/send")
//    public String SendValite(User user) {
//        //userService.SendValite(user);
//        return "redirect:/list";
//    }
    
    /**
     * 15.验证短信(不明确参数和数据类型)
     * /user/sms/verify
     * phone:手机号
     * */
    
//    @RequestMapping("/sms/verify")
//    public String SendValite(User user) {
//        //userService.SendValite(user);
//        return "redirect:/list";
//    }

    /**
     * 16.用户登录(不明确参数和数据类型)
     * /user/login
     * account:账号
       pwd:密码
     * */
    
    @RequestMapping("/login")
    public String Login(@PathVariable String name, @PathVariable String password) {
        //userService.SendValite(user);
    	User user = userRepo.findByNameAndPassword(name, password);   	
    	if(user == null){
    		return "请注册";
    	}
    	
        return "200,success";
    }

    /**
     * 17.获取用户数据(不明确参数和数据类型)
     * access_token: 访问令牌
     * /user
     *     
     * */
    
    @RequestMapping("")
    @JsonView
    public Object getUser(@PathVariable String access_token) {
        //userService.SendValite(user);
    	Authorization auth = auRepo.getByAccessToken(access_token);   
    	User user = auth.getUser();   	
    	
        return user.toString() ;
    }

    
    
//    @RequestMapping("/add")
//    public String add(User user) {
//        userService.save(user);
//        return "redirect:/list";
//    }

//    @RequestMapping("/toEdit")
//    public String toEdit(Model model,Long id) {
//        User user=userService.findUserById(id);
//        model.addAttribute("user", user);
//        return "user/userEdit";
//    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/list";
    }


//    @RequestMapping("/delete")
//    public String delete(Long id) {
//        userService.delete(id);
//        return "redirect:/list";
//    }
}