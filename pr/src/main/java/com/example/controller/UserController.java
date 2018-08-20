package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
/*
@RequestMapping("/home")
*/
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }
}
