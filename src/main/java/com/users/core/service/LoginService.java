package com.users.core.service;

import com.users.core.entity.Login;
import com.users.core.repository.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("loginService")
public class LoginService implements UserDetailsService {

    @Autowired
    @Qualifier("userManager")
    private UserManager userManagerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login user = userManagerRepo.findByUser(username);
        return new User(user.getUser(),user.getPassword(),user.isActive(),user.isActive(),user.isActive(),user.isActive(),buildgrante(user.getRol()));
    }

    public List<GrantedAuthority> buildgrante(byte rol){
        String[] roles = {"READER","USER","ADMINISTRATOR"};
        List<GrantedAuthority> auths = new ArrayList<>();

        for(int i = 0; i<rol; i++){
            auths.add(new SimpleGrantedAuthority(roles[i]));
        }

        return auths;
    }
}
