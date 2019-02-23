package com.users.core.model;

import com.users.core.entity.User;

import java.util.List;

public class MUser{

    public MUser(){

    }

    public MUser(User user){

        this.id = user.getId();
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.movilephone = user.getMovilephone();

    }


    public MUser(long id, String name, String lastname, String email, int movilephone) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.movilephone = movilephone;
    }

    private long id;

    private String name;

    private String lastname;

    private String email;

    private int movilephone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMovilephone() {
        return movilephone;
    }

    public void setMovilephone(int movilephone) {
        this.movilephone = movilephone;
    }
}
