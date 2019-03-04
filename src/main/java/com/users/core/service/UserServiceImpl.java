package com.users.core.service;

import java.util.List;

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
import org.springframework.transaction.annotation.Transactional;


@Service("service")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("repository")
    private UserRepository repository;

    @Autowired
    @Qualifier("converter")
    private Converter converter;

    //Creación de Log (para ver la información de como va nuestro programa)
    private static final Log logger = LogFactory.getLog(UserService.class);

    @Override
    @Transactional(readOnly = true)
    public List<MUser> getUsers() {
        logger.info("Get Users from the database");
        return converter.converterList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MUser> getByPage(Pageable pageable) {
        logger.info("Get Users from the database");
        return converter.converterList(repository.findAll(pageable).getContent());

    }

    @Override
    @Transactional(readOnly = true)
    public MUser getUser(long id) {
        logger.info("Get User from the database");
        return new MUser(repository.findById(id));
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        try {
            repository.save(user);
        } catch (Exception e) {
        }
    }

    @Override
    public void deleteUser(long id) {
        logger.warn("Delete user");
        try {
            User user = repository.findById(id);
            repository.delete(user);
            logger.info("Successfully deleted user");

        } catch (Exception e) {
            logger.error("An error has occured deleting user");
        }
    }

    public MUser getForNameAndLastname(String name, String lastname) {
        logger.info("Get User from the database");
        return new MUser(repository.findByNameAndLastname(name, lastname));
    }

}
