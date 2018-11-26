package com.users.core.entity;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;

@Table(name="user")
@Entity
public class User {

    public User(){

    }
    public User(long id, String name, String lastname, String email, int movilephone) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.movilephone = movilephone;
    }

    @GeneratedValue
    @Id
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="lastname")
    private String lastname;
    @Column(name="email")
    private String email;
    @Column(name="movilephone")
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
