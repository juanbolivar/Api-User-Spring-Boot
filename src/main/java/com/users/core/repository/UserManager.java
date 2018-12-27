package com.users.core.repository;

import com.users.core.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("userManager")
public interface UserManager extends JpaRepository<Login, Serializable> {

    public abstract Login findByUser(String user);
}
