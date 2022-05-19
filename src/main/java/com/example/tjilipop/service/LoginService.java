package com.example.tjilipop.service;

import com.example.tjilipop.model.Login;
import com.example.tjilipop.utility.LoginManager;

public class LoginService {
    private LoginManager loginManager = new LoginManager();

    public boolean isPasswordValid(String password) {
        if(!password.isEmpty() && password.length() <= 50) {
                return true;
        }
        return false;
    }

    public boolean doPasswordAndUsernameMatch(String username, String password) {
        String usernameFromDB = loginManager.getLogin().getUsername();
        String passwordFromDB = loginManager.getLogin().getPassword();

        if (username.equals(usernameFromDB) && password.equals(passwordFromDB)) {
            return true;
        }

        return false;
    }

    public boolean arePasswordsIdentical(String password1, String password2) {
        if(password1.equals(password2)) {
            return true;
        }
        return false;
    }
}
