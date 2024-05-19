package com.yael.curso.webapp.cursowebapp.models;

public class Users {
    
    public Users(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }


    private String name;
    private String lastname;
    private String email;

    
    public Users() {
    }
    public Users(String name, String lastname, String email) {
        this(name,lastname);
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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

}
