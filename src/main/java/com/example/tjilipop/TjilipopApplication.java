package com.example.tjilipop;

import com.example.tjilipop.service.LoginService;
import com.example.tjilipop.utility.LoginManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TjilipopApplication {
    LoginManager loginManager = new LoginManager();
    public static void main(String[] args) {
       // System.out.println(loginManager.getLogin());
        SpringApplication.run(TjilipopApplication.class, args);
    }
/*dette er test for at se om commit og push virker*/
}
