package com.example.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.shop.entity.CarouselItem;
import com.example.shop.entity.CarouselView;

import com.example.shop.entity.GridItem;
import com.example.shop.entity.GridView;
import com.example.shop.entity.Indexconfig;

import com.example.shop.repository.CarouselItemRepository;
import com.example.shop.repository.CarouselViewRepository;

import com.example.shop.repository.GridItemRepository;
import com.example.shop.repository.GridViewRepository;
import com.example.shop.repository.IndexconfigRepository;
import com.example.shop.service.IndexService;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
@Service("indexServiceImpl")
public class IndexServiceImpl implements IndexService {
	
    @Autowired
    private CarouselViewRepository carRepo;
    @Autowired
    private GridViewRepository gridRepo;
    @Autowired
    private IndexconfigRepository indexRepo;
    
    @Autowired
    private CarouselItemRepository carItemRepo;
    
    @Autowired
    private GridItemRepository gridItemRepo;
    
    private Indexconfig indexconfig;
    
//获取最外层rows内容，形成rows对象
	public JSONObject getRowsArray(){
		JSONObject reobj = new JSONObject();
		reobj.put("rows", getRowsList());
		return reobj;
	}

	
	// 形成rows,将根目录的carousel和grid组成每个row
	
	
	public JSONArray getRowsList(){
		
		JSONArray result = new JSONArray();
		
		Indexconfig IC = getConfig();
		
		//Integer index_id = IC.getId();
		Integer index_id = 1;
		//获取根目录的gridview  ,通过是实体类去查找 
		List<GridView> gridList = gridRepo.findByIndexconfigAndParentId(IC, -1);
		
		System.out.println("11111111111111");
		int count_g = gridList.size();
		for(GridView gv:gridList){
			JSONObject row = new JSONObject();
			row.put("style_id", gv.getStyleId());
			row.put("ratio", gv.getRatio());
			row.put("data", getGridViewList(gv.getIndexconfig()));
			result.add(row);
		}
		List<CarouselView> cList = carRepo.findByIndexconfig(IC);
		int count_c = cList.size();
		for(CarouselView cv: cList){
			JSONObject row = new JSONObject();
			row.put("style_id", cv.getStyleId());
			row.put("ratio", cv.getRatio());
			row.put("data", getCarouselViewList(cv.getIndexconfig()));
			result.add(row);
		}
		return result;
		
	}
	
	//获取最新的配置文件
	public Indexconfig getConfig(){
		
//		//indexconfig = indexRepo.findTopByOrderByIdAsc();
//		Float a = new Float(0.5);
//			
//		indexconfig = indexRepo.findByRato(a);
//		return indexconfig;
		return this.indexRepo.getOne(1);
	}
	




	
	

	//carousel_item的images
	public JSONArray getImages(CarouselView cv){
		List<CarouselItem> itemList = carItemRepo.findByCarouselView(cv);
		JSONArray arr = new JSONArray();
		for(CarouselItem item : itemList){
			JSONObject obj = new JSONObject();
			obj.put("img_url", item.getImgUrl());
			obj.put("action_url", item.getActionUrl());
			arr.add(obj);
		}
		return arr;		
	}
    //grid_item的最底层的cells	
	public JSONArray getCells(GridView gv){
		List<GridItem> itemList = gridItemRepo.findByGridView(gv);
		JSONArray arr = new JSONArray();
		for(GridItem item : itemList){
			JSONObject obj = new JSONObject();
			obj.put("img_url", item.getImgUrl());
			obj.put("action_url", item.getActionUrl());
			obj.put("weight", item.getWeight());
			arr.add(obj);
		}
		return arr;
		
	}
	//CarouselView格式化，只返回duration，images
	public JSONObject getCData(CarouselView cv){
		JSONObject obj = new JSONObject();
		obj.put("duration", cv.getDuration());
		obj.put("images", getImages(cv));
		return obj;
	}
	
	  
	//gridview格式化，暂时没用
	public JSONObject getGData(GridView gv){
		JSONObject obj = new JSONObject();
		

		obj.put("cells", getCells(gv));
		
//		if(gv.getOrientation() != null || !gv.getOrientation().isEmpty()){
//			obj.put("orientation", gv.getOrientation());
//		}
//		if(gv.getWeight() != 0){
//			obj.put("weight", gv.getWeight());
//		}
//		if(gv.get)
//		obj.put("orientation", gv.getOrientation());
//		
//		obj.put("cells", getCells(gv.getId()));
		return obj;
	}
	
	

	//CarouselViewList
	
	@Transactional(readOnly = true)
	public JSONArray getCarouselViewList(Indexconfig ic) {
		// TODO Auto-generated method stub
		List<CarouselView> clist =  carRepo.findByIndexconfig(ic);
		JSONArray cresult = new JSONArray();
		for(CarouselView cv:clist){
			cresult.add(getCData(cv));
		}	
		return cresult;
	}
	
	
	
	//递归获得
	
	@Transactional(readOnly = true)
	public JSONArray getGridViewList(Indexconfig ic) {
		// TODO Auto-generated method stub
		//List<GridView> list =  gridRepo.findByIndexconfig(index_id);

		
    	JSONArray cataList = recursive(ic,-1);
		for(Object obj : cataList){		
		   System.out.println(obj.toString());
		}
		return cataList;
	}
	
	
	public JSONArray recursive(Indexconfig ic,Integer parent_id){
		List<GridView> gridlist = gridRepo.findByIndexconfigAndParentId(ic, parent_id);

    	
    	if(gridlist == null||gridlist.isEmpty()){
    		return null;
    	}
    	JSONArray result = new JSONArray();
    	
    	for(GridView gridv : gridlist){
    		
			JSONObject obj = new JSONObject();
			if(gridv.getOrientation()!=null || !gridv.getOrientation().isEmpty()){
				obj.put("orientation", gridv.getOrientation());
			}
			if(gridv.getWeight()!= 0){
				obj.put("weight", gridv.getWeight());
			}
			
			if(recursive(ic,gridv.getId()) != null){
				
				JSONArray arr = new JSONArray();
				arr.add(recursive(ic,gridv.getId()));
				obj.put("cells",recursive(ic,gridv.getId()));
			} else{
				JSONArray arr = getCells(gridv);
				//JSONObject objdata = getGData(gridv);
				obj.put("cells", arr);
			}
			result.add(obj);
    	}
    	return result;
    }
	


}
