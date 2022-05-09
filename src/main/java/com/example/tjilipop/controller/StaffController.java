package com.example.tjilipop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @GetMapping()
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

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/staff-profile-settings")
    public String profileSettings() {
        return "staff-profile-settings";
    }
}
