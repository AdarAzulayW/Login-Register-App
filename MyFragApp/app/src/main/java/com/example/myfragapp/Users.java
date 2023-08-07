package com.example.myfragapp;

public class Users {
    public String fullname;
    public String email;
    public String password;
    public String phone;
    public String id;

    public Users(String fullname, String email, String password, String phone, String id) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.id = id;
    }

    public Users () {
    }

    public String getFullname() {
        return fullname;
    }

}


