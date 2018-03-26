package com.example.shop.service;



import java.util.List;

import com.example.shop.entity.Authorization;
import com.example.shop.entity.Role;
import com.example.shop.entity.User;

public interface UserService {

    public List<User> getUserList();

    public User findUserById(long id);

    public void save(User user);

    public void edit(User user);

    public void delete(long id);

    public User findOne(long id);
    
    public User findByName(String name);
    
    public User getUser(String name);
    
    public Role getRole(User user);
    
    public List<Authorization> getAuthorization(User user);


}