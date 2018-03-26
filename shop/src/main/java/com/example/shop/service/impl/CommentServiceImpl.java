package com.example.shop.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.entity.Comment;
import com.example.shop.entity.Product;
import com.example.shop.repository.CommentRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.CommentService;
import com.example.shop.service.ProductService;
@Service("CommentServiceImpl")
@Transactional
public class CommentServiceImpl implements CommentService{
	@Autowired
    private CommentRepository comRepo;
	@Autowired
    private ProductService productservice;
	@Override
	public List<Comment> findAll() {
		// TODO Auto-generated method stub
		return comRepo.findAll();
	}

	@Override
	public void saveComment(Comment comment) {
		// TODO Auto-generated method stub
		comRepo.save(comment);
	}

	@Override
	public Comment findOne(long id) {
		// TODO Auto-generated method stub
		return comRepo.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		comRepo.delete(id);
		
	}

	@Override
	public List<Comment> findById(long id) {
		// TODO Auto-generated method stub
		return comRepo.findById(id);
	}
	//通过商品id获得商品，通过商品获得该商品的评论
	@Override
	public List<Comment> findByPId(long id) {
		// TODO Auto-generated method stub
		Product product = productservice.findOne(id);
		return comRepo.findByProduct(product);
	}
}
