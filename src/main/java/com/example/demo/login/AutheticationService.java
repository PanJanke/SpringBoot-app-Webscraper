package com.example.demo.login;

public class AutheticationService {

    public boolean authenticate(String userName, String password){
        boolean isValidUserName= userName.equalsIgnoreCase("admin");
        boolean isValidPassword = password.equalsIgnoreCase("admin");
        return  isValidPassword && isValidUserName;
    }
}
