package com.users.core.controller;

import com.users.core.entity.User;
import com.users.core.model.MUser;
import com.users.core.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    @Qualifier("service")
    UserService userService;

    private static final Log logger = LogFactory.getLog(UserService.class);

    //Traer todos los usuarios con paginación
    @GetMapping("/users")
    public List<MUser> getUsers(Pageable pageable) {

        return userService.getByPage(pageable);
    }

    //Traer un usuario por su id
    @GetMapping("/users/{id}")
    public MUser getUser(@PathVariable("id") long id) {
        MUser mUser = userService.getUser(id);
        return mUser;
    }

    //valid es para el json que nos envía,lo convertimos a una clase
    //crear nuevo usuario
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        logger.info("Creating User");
        try {
            userService.saveUser(user);
            logger.info("Successfully created User");
        } catch (Exception e) {
            logger.error("An error has occured creating User");
        }

        return user;
    }

    //actualizar usuario existente
    @PutMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user) {
        logger.info("Updating User");
        try {
            userService.saveUser(user);
            logger.info("Successfully updated User");
        } catch (Exception e) {
            logger.error("An error has occured updating User");
        }

        return user;
    }

    //Eliminar usuario
    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUseryoutyo(@PathVariable("id") long id) {

        userService.deleteUser(id);
    }
}
