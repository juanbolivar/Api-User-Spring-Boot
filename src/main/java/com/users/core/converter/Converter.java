package com.users.core.converter;

import com.users.core.entity.User;
import com.users.core.model.MUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("converter")
public class Converter {
    public List<MUser> converterList(List<User> users){
        List<MUser> musers = new ArrayList<>();

        for(User user: users){
            musers.add(new MUser(user));
        }

        return musers;
    }
}
