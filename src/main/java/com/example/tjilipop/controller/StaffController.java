package com.example.tjilipop.controller;

import com.example.tjilipop.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @GetMapping()
    public String loginPage() {
        return "staff-login";
    }

    @PostMapping()
    public String login(@ModelAttribute Login loginData) {

        return "hej";
    }

    @GetMapping("/staff-frontpage")
    public String frontPage() {
        return "staff-frontpage";
    }

    @GetMapping("/reservation-requests")
    public String reservationRequests() {
        return "staff-reservation-requests";
    }

    @GetMapping("/edit-events")
    public String editEvents() {
        return "staff-edit-events";
    }

    @GetMapping("/edit-menu")
    public String editMenu() {
        return "edit-events";
    }

    @GetMapping("/test1")
    public String test() {
        return "test";
    }

    @GetMapping("/profile-settings")
    public String profileSettings() {
        return "staff-profile-settings";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu-øl";
    }
}
