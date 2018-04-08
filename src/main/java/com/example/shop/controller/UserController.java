package com.example.shop.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.entity.Authorization;
import com.example.shop.entity.JsonString;
import com.example.shop.entity.User;
import com.example.shop.repository.AuthorizationRepository;
import com.example.shop.repository.ShipAddressRepository;
import com.example.shop.repository.UserRepository;
//import com.example.shop.service.ShipAddressService;
import com.example.shop.service.UserService;
import com.example.shop.util.JWTUtil;
import com.fasterxml.jackson.annotation.JsonView;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import shop.example.shop.exception.UnauthorizedException;


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
	
//	@Resource
//	ShipAddressService shipService;
 
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
//    @RequestMapping(value = "/shipaddress/default/")
//    public JsonString DefaultAddress(@PathVariable String access_token) {
//    	JsonString json = new JsonString();
//    	json.put("code",1);	    
//		json.put("data",shipService.getDefaultAddressArray(access_token));
//        return new JsonString("1","",);
//    }
	
	
    
	/**
	 * 10：用户收货地址列表（over）
	 * /user/shipaddress/
	 * @param access_token
	 * 
	 * */
    @RequestMapping(value = "/shipaddress/")
    public JsonString Addresslist() {
    	Subject subject = SecurityUtils.getSubject();
    	JsonString json = new JsonString();
        if (subject.isAuthenticated()) {
        	
            return new JsonString(200, "You are already logged in", null);
            
            
        } else {
            return new JsonString(200, "You are guest", null);
        }
        
		    
	    // json.put("code",1);
		// json.put("data",shipService.getShipAddressArray(access_token));
        // return json;
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
       
       注销，在客户端本地删除token即可，服务端不需实现。
     * */
    
    @PostMapping("/login")
    public JsonString login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        User user = userService.getUser(username);
        System.out.println(user.getUsername());
        if (user.getPassword().equals(password)) {
            return new JsonString(200, "Login success", JWTUtil.sign(username, password));
        } else {
            throw new UnauthorizedException();
        }
    }
    
    
    
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public JsonString Login(@PathVariable String name, @PathVariable String password) {
//        //userService.SendValite(user);
//    	
//    	
//    	User user = userService.findByName(name);
//    	
////    	
////    	//盐（用户名+随机数）
////        String salt = user.getSalt();
////        //原密码
////        String encodedPassword = ShiroKit.md5(password, username + salt);
//    	
//    	//String encodedPassword = ShiroKit.md5(password, name);
//        //if (user.getPassword().equals(encodedPassword)) {
////            return new BaseResponse(true, "Login success", JWTUtil.sign(username, encodedPassword));
////        } else {
////            throw new UnauthorizedException();
////        }
//    	
//    	
//    	if(user == null){
//    		return new JsonString(200, "Login fail",null);
//    	}
//    	if (user.getPassword().equals(password)) {
//            return new JsonString(200, "Login success", JWTUtil.sign(name, password));
//        } else {
//            throw new UnauthorizedException();
//        }  
//    }

    /**
     * .用户注册(不明确参数和数据类型)
     * /user/login
     * account:账号
       pwd:密码
       
     *@modelAttribute 参数在body --》x--form-ur
     *@RestController 代替了 @Controller，表示该类里面的方法都是返回 JSON 数据
     *@RequestBody
     * */
    
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    
  //@JsonIgnoreProperties(ignoreUnknown = true)//忽略未知属性
    public JsonString Register(@RequestBody User user) {
        //userService.SendValite(user);    
    	String username = user.getUsername();
    	String password = user.getPassword();
    	System.out.println("username"+username);
    	System.out.println("password"+password);
    	if(userRepo.findByUsername(user.getUsername())!= null){
    		return new JsonString(201, "已存在该用户，请登录",null);
    	}
    	
    	userRepo.save(user);
    	return new JsonString(200, "注册成功",JWTUtil.sign(user.getUsername(), user.getPassword()));
    }

    
    
    
    /**
     * 17.获取用户数据(不明确参数和数据类型)
     * access_token: 访问令牌
     * /user
     *     
     * */
//    
//    @RequestMapping("")
//    @JsonView
//    public Object getUser(@PathVariable String access_token) {
//        //userService.SendValite(user);
//    	Authorization auth = auRepo.getByAccessToken(access_token);   
//    	User user = auth.getUser();   	
//    	
//        return user.toString() ;
//    }

    
    
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