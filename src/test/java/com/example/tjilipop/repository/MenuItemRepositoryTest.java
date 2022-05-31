package com.example.tjilipop.repository;

import com.example.tjilipop.service.LoginService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemRepositoryTest {

    @Test
    void loginService() {
        var loginService = new LoginService();
        assertEquals(true, loginService.doPasswordAndUsernameMatch("Rasmus", "super"));
        assertEquals(false, loginService.doPasswordAndUsernameMatch("rusmus", "supah"));
        assertEquals(true, loginService.isPasswordValid("scurge"));
        assertEquals(false,loginService.isPasswordValid("nfeiwonfoiewnfewnoifnewoifewnoifnewoinfeoiwnfewnoifnewoinfoiewnfoiewnoifnewoifneoiwnfoiewnoifenwoifenwoifnewoinfeoiwnfoiewnfioewnoifenwoifnewoinfeoienwoinefoinewoienfoinewoinefoinewoienfoinewfoinewoifneoinwoinfeoiwnfoiewnfoiewnfoinewfoinewoinfeoiwnfoienwoifenwoifnewoinfeoiwnfoienwoinfeoienwoienfoiewnfoiewni"));
        assertEquals(true, loginService.arePasswordsIdentical("baba","baba"));
        assertEquals(false,loginService.arePasswordsIdentical("supah","super"));
    }
}