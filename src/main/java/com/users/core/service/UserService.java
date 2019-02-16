package com.users.core.service;


import com.users.core.entity.User;
import com.users.core.model.MUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.users.core.repository.UserRepository;
import com.users.core.converter.Converter;

import org.springframework.data.domain.Pageable;

import java.util.List;

@Service("service")
public class UserService {

    @Autowired
    @Qualifier("repository")
    private UserRepository repository;

    @Autowired
    @Qualifier("converter")
    private Converter converter;

    //Creación de Log (para ver la información de como va nuestro programa)
    private static final Log logger = LogFactory.getLog(UserService.class);

    public boolean create(User user) {
        logger.info("Creating new user");
        try {
            repository.save(user);
            logger.info("Successfully created user");
            return true;
        } catch (Exception e) {
            logger.error("An error has occured creating user");
            return false;
        }
    }

    public boolean update(User user) {
        logger.info("Updating user");
        try {
            repository.save(user);
            logger.info("Successfully updated user");
            return true;
        } catch (Exception e) {
            logger.error("An error has occured updating user");
            return false;
        }
    }

    public boolean delete(long id, String name) {
        logger.warn("Delete user");
        try {
            User user = repository.findByNameAndId(name, id);
            repository.delete(user);
            logger.info("Successfully deleted user");
            return true;
        } catch (Exception e) {
            logger.error("An error has occured deleting user");
            return false;
        }
    }

<<<<<<< HEAD
    public List<MUser> getUsers() {
//        List<MUser> users = null;
//
//        List<User> usersEntity = repository.findAll();
        logger.info("Get Users to database");
        return converter.converterList(repository.findAll());
=======
    public List<MUser> getUsers(){
        List<MUser> users = null;

        List<User> usersEntity = repository.findAll();

        return coverter.converterList(repository.findAll());
>>>>>>> fa8cd29... La aplicación funciona y he creado el metodo, para traer un usuario por su id
    }

    public MUser getForNameAndLastname(String name, String lastname) {
        return new MUser(repository.findByNameAndLastname(name, lastname));
    }

<<<<<<< HEAD
    public List<MUser> getByPage(Pageable pageable) {
        return converter.converterList(repository.findAll(pageable).getContent());
=======
    public MUser getUser(long id){
        return new MUser(repository.findById(id));
>>>>>>> fa8cd29... La aplicación funciona y he creado el metodo, para traer un usuario por su id
    }
}
