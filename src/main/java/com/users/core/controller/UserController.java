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

    @Autowired
    @Qualifier("service")
    UserService service;

    //Insertar nuevo usuario
    @PutMapping("/user")
    public boolean addUser(@RequestBody @Valid User user){

        return service.create(user);
    }

    //actualizar usuario existente
    //valid es para el json que nos envía,lo convertimos a una clase
    @PostMapping("/user")
    public boolean updateUser(@RequestBody @Valid User user){

        return service.update(user);
    }

    //Eliminar usuario
    @DeleteMapping("/user/{id}/{name}")
    public boolean deleteUser(@PathVariable("id") long id,@PathVariable("name") String name){

        return service.delete(id,name);
    }

    //Traer lista de los usuarios existentes en la base de datos
    @GetMapping("/users")
    public List<MUser> getUsers(){

        return service.getUsers();
    }
}
