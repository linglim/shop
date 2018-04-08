package com.example.shop.service.impl;

import java.util.List;

import javax.persistence.Cacheable;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.entity.Comment;
import com.example.shop.entity.Group_specification;
import com.example.shop.entity.Product;
import com.example.shop.entity.ProductGroup;
import com.example.shop.entity.ProductSpecification;
import com.example.shop.entity.Shop;
import com.example.shop.entity.User;
import com.example.shop.repository.CategoryRepository;

import com.example.shop.repository.Group_specificationRepository;
import com.example.shop.repository.ProductGroupRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.ProductSpecificationRepository;
import com.example.shop.repository.ShopRepository;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.ProductService;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
@Service("ProductServiceImpl")
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository proRepo;
	
    @Autowired
    private ProductGroupRepository pgRepo;
    
    @Autowired
    private ShopRepository shRepo;
    
    @Autowired
    private ProductSpecificationRepository psRepo;
    
    @Autowired
    private Group_specificationRepository gsRepo;
    
    @Autowired
    private UserRepository userRepo;
    
	public JSONObject getProduct(long product_id) {
		// TODO Auto-generated method stub
		Product product = proRepo.getOne(product_id);
		
	    ProductGroup pg = product.getProductGroup();		
	    long pgid = pg.getId();
	    long shop_id = product.getShopId();
	    Shop sh = shRepo.findOne(shop_id);
	    
	    List<ProductSpecification> ps_l = product.getProductSpecifications();
	    
	    
	    
	    System.out.println(product.getName());
	 	
	    
	    
	    JSONObject data = new JSONObject();
	    data.put("id", product.getId());
	    data.put("product_group_id", pgid);
	    data.put("name", product.getName());
	    data.put("sub_title", product.getSubTitle());
	    data.put("price", product.getPrice());
	    data.put("img_urls",product.getMobileIntroImgs());
	    data.put("product_info", product.getProductInfos());		
	    data.put("intro_imgs", product.getMobileIntroImgs());
	    data.put("shop",sh);
	    data.put("comment_count", product.getComments().size());
	    data.put("product_features", findPS(product));
	    
	    data.put("features", findGPS(pg));
	    
		   
		
		return data;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return proRepo.findAll();
	}

	@Override
	public void saveUser(Product product) {
		// TODO Auto-generated method stub
		proRepo.save(product);
	}

	//@Cacheable("products")
	public Product findOne(long id) {
		// TODO Auto-generated method stub
		
		return proRepo.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		proRepo.delete(id);
		
	}

	@Override
	public List<Product> findByName(String name) {
		// TODO Auto-generated method stub
		return proRepo.findByName(name);
	}



	@Override
	public ProductGroup findPG(long gid) {
		// TODO Auto-generated method stub
		return pgRepo.findOne(gid);
		
	}

	@Override
	public Shop findShop(long s_id) {
		// TODO Auto-generated method stub
		return shRepo.findOne(s_id);
		
	}
//获得商品参数
	@Override
	public JSONArray findPS(long p_id) {
		// TODO Auto-generated method stub
		
		List<ProductSpecification> pslist = psRepo.findByProduct(p_id);
		JSONArray json = new JSONArray();
		for(ProductSpecification ps:pslist){
			JSONObject obj = new JSONObject ();
			obj.put("feature_id", ps.getGroupSpecification());
			obj.put( "option_id", ps.getGroupSpecificationOption());			
			json.add(obj);
		}
		return json;
	}
	
	public JSONArray findPS(Product product) {
		// TODO Auto-generated method stub
		
		List<ProductSpecification> pslist = product.getProductSpecifications();
		JSONArray json = new JSONArray();
		for(ProductSpecification ps:pslist){
			JSONObject obj = new JSONObject ();
			obj.put("feature_id", ps.getGroupSpecification());
			obj.put( "option_id", ps.getGroupSpecificationOption());			
			json.add(obj);
		}
		return json;
	}

	@Override
	public JSONArray findGPS(long g_id) {
		// TODO Auto-generated method stub
		
		List<Group_specification> pslist = gsRepo.findByProductGroup(g_id);
		JSONArray json = new JSONArray();
		for(Group_specification ps : pslist){
			
			JSONObject obj = new JSONObject ();
			obj.put("id", ps.getProductGroup().getId());
			obj.put("feature_name", ps.getName());
			obj.put("options", ps.getGroupSpecificationOptions());			
			json.add(obj);
		}
		return json;
	}
		public JSONArray findGPS(ProductGroup group) {
			// TODO Auto-generated method stub
			
			List<Group_specification> pslist = group.getGroupSpecifications();
			JSONArray json = new JSONArray();
			for(Group_specification ps : pslist){
				
				JSONObject obj = new JSONObject ();
				obj.put("id", ps.getId());
				obj.put("feature_name", ps.getName());
				obj.put("options", ps.getGroupSpecificationOptions());			
				json.add(obj);
			}
			return json;
	}

		@Override
		public JSONObject getComment(Product product) {
			// TODO Auto-generated method stub
			List<Comment> c_list = product.getComments();
//			for(Comment c : c_list){
//				//long uid = c.getUserId();
//				User user = userRepo.
//				//User user = userRepo.findById(uid);
//				JSONObject obj = new JSONObject ();
//				obj.put("buyer", user);
//				obj.put("rating", c.getRate());
//				obj.put("comment", c);		
//			}
			
			
			return null;
		}

	



}
