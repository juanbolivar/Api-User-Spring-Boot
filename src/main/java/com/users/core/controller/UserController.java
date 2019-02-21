package com.users.core.controller;

import com.users.core.entity.User;
import com.users.core.model.MUser;
import com.users.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController{
    
    //codigo funcionando
    @Autowired
    @Qualifier("service")
    UserService service;

    @PutMapping("/user")
    public boolean addUser(@RequestBody @Valid User user){

        return service.create(user);
    }

    @PostMapping("/user")
    public boolean updateUser(@RequestBody @Valid User user){

        return service.update(user);
    }

    @DeleteMapping("/user/{id}/{name}")
    public boolean deleteUser(@PathVariable("id") long id,@PathVariable("name") String name){

        return service.delete(id,name);
    }

    @GetMapping("/users")
    public List<MUser> getUsers(){
        return service.get();
    }
}
