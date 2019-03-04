package com.users.core.service;

import java.util.List;

import com.users.core.entity.User;
import com.users.core.model.MUser;
import org.springframework.data.domain.Pageable;

public interface UserService {
    public List<MUser> getUsers();

    public List<MUser> getByPage(Pageable pageable);

    public void saveUser(User user);

    public MUser getUser(long id);

    public void deleteUser(long id);
}