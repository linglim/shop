package com.example.shop.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.entity.Authorization;
import com.example.shop.entity.Role;
import com.example.shop.entity.User;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }
    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }


	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		 userRepository.delete(id);
	}

	@Override
	public User findOne(long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}
	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(name);
	}
	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		
		User user = userRepository.findByUsername(name);
		if(user == null){
			return null;
		}
		
		return user;
	}
	
	
	
	
	
	@Override
	public Role getRole(User user) {
		// TODO Auto-generated method stub
		//return userRepository.findByName(name);
		return null;
	}
	@Override
	public List<Authorization> getAuthorization(User user) {
		// TODO Auto-generated method stub
		return null;
	}









}