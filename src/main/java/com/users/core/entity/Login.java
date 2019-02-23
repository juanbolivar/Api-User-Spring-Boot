//package com.users.core.entity;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name="LOGIN")
//public class Login implements Serializable {
//
//    @GeneratedValue
//    @Id
//    @Column(name="ID",unique = true)
//    private long id;
//
//    @Column(name="USER",unique = true)
//    private String user;
//
//    @Column(name="PASSWORD")
//    private String password;
//
//    @Column(name="ROL")
//    private byte rol;
//
//    @Column(name="ACTIVE")
//    private boolean active;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getUser() {
//        return user;
//    }
//
//    public void setUser(String user) {
//        this.user = user;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public byte getRol() {
//        return rol;
//    }
//
//    public void setRol(byte rol) {
//        this.rol = rol;
//    }
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }
//}
