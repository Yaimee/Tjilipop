package com.example.tjilipop.service;

import com.example.tjilipop.model.Login;
import com.example.tjilipop.utility.LoginManager;
//Rasmus's kode
public class LoginService {
    private LoginManager loginManager = new LoginManager();
    //tester om password har den rette længde og om der er angivet et
    public boolean isPasswordValid(String password) {
        if(!password.isEmpty() && password.length() <= 50) {
                return true;
        }
        return false;
    }
    //tester om password og brugernavn matcher det i databasen
    public boolean doPasswordAndUsernameMatch(String username, String password) {
        String usernameFromDB = loginManager.getLogin().getUsername();//"Rasmus";
        String passwordFromDB = loginManager.getLogin().getPassword();//"super";

        if (username.equals(usernameFromDB) && password.equals(passwordFromDB)) {
            return true;
        }

        return false;
    }
    //tester om passwords er identiske
    public boolean arePasswordsIdentical(String password1, String password2) {
        if(password1.equals(password2)) {
            return true;
        }
        return false;
    }
}
