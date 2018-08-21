package com.example.service;

import com.example.model.User;

public interface UserService {
    public User findUserByUsername(String username);
    public void saveUser(User user);

    public String getT(String s);
}
