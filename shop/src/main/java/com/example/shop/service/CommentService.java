package com.example.shop.service;

import java.util.List;

import com.example.shop.entity.Comment;
import com.example.shop.entity.Product;

import net.minidev.json.JSONArray;

public interface CommentService {
	/**
	 * 评论
	 * 
	 * @return 评论
	 */
    //public JSONArray getProduct(int product_id);
    
    public List<Comment> findAll();
    
    public void saveComment(Comment comment);
    
    public Comment findOne(long id);

    public void delete(long id);

    public List<Comment> findById(long id);
    
    public List<Comment> findByPId(long id);
 
}
