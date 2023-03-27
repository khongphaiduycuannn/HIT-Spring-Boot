package com.example.btvn_buoi3;

public class User {

    private int id;
    private String name;
    private String password;
    private String fullname;

    public User() {
    }

    public User(int id, String name, String password, String fullname) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.fullname = fullname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean equal(User user) {
        return (this.name.equals(user.name));
    }

}
