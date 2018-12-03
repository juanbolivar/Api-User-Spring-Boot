package com.users.core.controller;

import com.users.core.entity.User;
import com.users.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class UserController{

    @Autowired
    @Qualifier("service")
    UserService service;

    @PutMapping("/user")
    public boolean addUser(@RequestBody @Valid User user){

        return service.create(user);
    }
}
