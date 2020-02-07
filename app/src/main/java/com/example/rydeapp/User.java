package com.example.rydeapp;

public class User {

    private String Username;
    private String Password;
    private String PhoneNumber;

    public User(){
    }

    public User(String Username, String Password, String PhoneNumber){
        this.Username = Username;
        this.Password = Password;
        this.PhoneNumber = PhoneNumber;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
