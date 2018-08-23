package com.example.service;

import com.example.model.User;
import com.example.service.dto.UserListDto;

import java.util.List;

public interface UserService {
    public User findUserByUsername(String username);
    public void saveUser(User user);
    public List<UserListDto> findAll();
}
