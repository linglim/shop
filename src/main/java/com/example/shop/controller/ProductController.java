package com.example.shop.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.entity.Comment;
import com.example.shop.entity.JsonString;
import com.example.shop.entity.Product;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.CommentService;
import com.example.shop.service.ProductService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/products")
public class ProductController {
//	@Resource(name = "CatagoryServiceImpl")
//	private CatagoryService categoryService;
	@Autowired
	private ProductService proservice;
	@Autowired
	private ProductRepository proRepo;
	
	@Autowired
	private CommentService comservice;
	
	
	/**
	 * @param id
	 * 接口2：获取某个指定id商品的信息
	 * 
	 * /products/{id}
	 * */
	 @RequestMapping(value = "/{id}",method = RequestMethod.GET)
	 @ResponseBody
	    public JsonString getProduct(@PathVariable long id) {
		 	JsonString js = new JsonString(1,"成功",proservice.getProduct(id)); 
	        return js;
	    }
	 
		/**
		 * @param id
		 * 接口3：添加商品,带修改
		 * 
		 * /products/{id}
		 * */
	 
	 @RequestMapping(value = "/",method = RequestMethod.POST)
	    public Product addUser(@PathVariable long id, @PathVariable String name,
	        @PathVariable String address)
	    {
		 Product product = new Product();
		 product.setId(id);
		 product.setName(name);
		// product.setAddress(address);
		 proservice.saveUser(product);
	        return product;
	    }
	 
	 
	 
		/**
		 * @param id
		 * 接口26：获取商品id(有问题，不清楚)
//		 * */
//	 @RequestMapping(value = "/product/")
//	 @ResponseBody
//	    public JSONObject index(@PathVariable Integer id) {
//		    JSONObject json = new JSONObject();
//		    
//		    json.put("code",1);
//		    json.put("data", proRepo.findById(id));
//		    
//		   // categoryService.getProductCategoryList();
//	        return json;
//	    }
	 
	 /**
		 * @param id
		 * 接口3： 商品评论列表
		 * /product/{id}/comment
		 * */
	
		 @RequestMapping(value = "/{id}/comments")
		 @ResponseBody
		    public JsonString getComment(@PathVariable long id) {
			 
			    //List<Comment> comments = comservice.findById(id);
//			    JSONObject json = new JSONObject();
//			    
//			    json.put("code",1);
//			    json.put("data",comservice.findByPId(id));
			 	
//			 	List<Comment> c_l = comservice.findByPId(id);
//			 	JSONArray array = new JSONArray();
//			 	for(Comment c : c_l){
//			 		JSONObject oj = new JSONObject();
//			 		oj.put("comment", c.getComment());
//			 		oj.put("rating", c.getRate());
//			 		oj.put("buyer", c.getUser());
//			 	}
			 	
			 	JsonString js = new JsonString(1,"成功",comservice.findByPId(id)); 
			    
			   // categoryService.getProductCategoryList();
		        return js;
		    }
	 
		 /**
			 * @param id
			 * 接口4： 添加商品评论
			 * /product/{id}/comment
			 * */
			 
		 

			 @RequestMapping(value = "/{id}/comment/add", method = RequestMethod.POST)
			 
			    public JSONObject AddComment(@PathVariable long id,@RequestBody Comment comment,@PathVariable String token) {
				 	//检查token
				    comservice.saveComment(comment);
				    JSONObject json = new JSONObject();
				    
				    json.put("code",200);
				    json.put("data", "success");
				    
				   // categoryService.getProductCategoryList();
			        return json;
			    }
	 
	 
	 
	 
}
