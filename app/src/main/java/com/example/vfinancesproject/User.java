package com.example.vfinancesproject;


public class User {

    private String email;
    private String password;
    private int id;


    public User(int id, String em, String pa)
    {
        this.id = id;
        this.email = em;
        this.password = pa;
    }

    public User(String em, String pas)
    {
        this.email = em;
        this.password = pas;
    }

    public User()
    {}
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

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
    public void setUser_email(String ema)
    {
        this.email = ema;
    }

    public void setUser_pass(String pas)
    {
        this.password = pas;
    }


}
