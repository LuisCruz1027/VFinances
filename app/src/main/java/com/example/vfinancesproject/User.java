package com.example.vfinancesproject;

public class User {
    String email,password;

    User(String em, String pa)
    {
        this.email = em;
        this.password = pa;
    }

    public User()
    {}

    public void setEmail(String em)
    {
        this.email = em;
    }

    public void setPassword(String pa)
    {
        this.password = pa;
    }
    public String getUser_email()
    {
        return this.email;
    }

    public String getUser_password()
    {
        return this.password;
    }


}
