package com.users.core.repository;

import com.users.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("repository")
public interface UserRepository extends JpaRepository<User, Serializable> {
    public abstract User findByName(String name);
    public abstract List<User> findById(long id);
    public abstract User findByNameAndLastname(String name,String lastname);

}
