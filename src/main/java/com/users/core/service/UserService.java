package com.users.core.service;


import com.users.core.entity.User;
import com.users.core.model.MUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.users.core.repository.UserRepository;
import com.users.core.converter.Converter;

import java.util.List;

@Service("service")
public class UserService {

    @Autowired
    @Qualifier("repository")
    private UserRepository repository;

    @Autowired
    @Qualifier("converter")
    private Converter coverter;

    public boolean create(User user){
        try {
            repository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean update(User user){
        try {
            repository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean delete(long id,String name){
        try {
            User user = repository.findByNameAndId(name,id);

            repository.delete(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<MUser> get(){
        List<MUser> users = null;

        List<User> usersEntity = repository.findAll();

        return coverter.converterList(repository.findAll());
    }

    public MUser getForNameAndLastName(String name,String lastname){
        return new MUser(repository.findByNameAndLastname(name,lastname));
    }

    public List<MUser> getForId(long id){
        return coverter.converterList(repository.findById(id));
    }
}
