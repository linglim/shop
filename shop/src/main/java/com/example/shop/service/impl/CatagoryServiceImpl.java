package com.example.shop.service.impl;
//
import java.util.ArrayList;
import java.util.List;
//
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
////
import com.example.shop.entity.Category;
import com.example.shop.service.CatagoryService;
import com.example.shop.repository.CategoryRepository;
//
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
//
//
//
//
//
@Service("CategoryServiceImpl")
public class CatagoryServiceImpl implements CatagoryService {
//
    @Autowired
    private CategoryRepository cataRepo;
	
  @Transactional(readOnly = true)
	public JSONArray getCategoryList() {
		// TODO Auto-generated method stub
    	JSONArray cataList = recursive((long) -1);
		for(Object obj : cataList){		
		   System.out.println(obj.toString());
		}
		return cataList;
	}
//    
    public JSONArray recursive(Long parent_id){
    	List<Category> cataList = cataRepo.findByParentId(parent_id);
    	
    	if(cataList == null||cataList.isEmpty()){
    		return null;
    	}
    	JSONArray result = new JSONArray();
    	
    	for(Category cata : cataList){
			JSONObject obj = new JSONObject();
			obj.put("name", cata.getName());
			obj.put("img_url", cata.getImgUrl());
			
			if(recursive(cata.getId()) != null){
				JSONArray arr = new JSONArray();
				arr.add(recursive(cata.getId()));
				obj.put("children",recursive(cata.getId()));
			}
			result.add(obj);
    	}
    	return result;
    }
	public Category findCategoryById(Long id) {
		// TODO Auto-generated method stub
		return cataRepo.findOne(id);
		//return null;
	}
	@Override
	public Category findCategoryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
