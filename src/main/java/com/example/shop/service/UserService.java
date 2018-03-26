package com.example.shop.service;



import java.util.List;

import com.example.shop.entity.User;

public interface UserService {

    public List<User> getUserList();

    public User findUserById(Integer id);

    public void save(User user);

    public void edit(User user);

    public void delete(Integer id);

	void delete(int id);

	User findUserById(int id);


}