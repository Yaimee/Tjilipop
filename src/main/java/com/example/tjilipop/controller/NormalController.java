package com.example.tjilipop.controller;

import com.example.tjilipop.model.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NormalController {
    /*Tobias kode ---------------------------------------------------------------------->*/

    /*Her skal man bruge getMapping hvis,
    man gerne vil linke til sine knapper i html
    skal linkes til V*/
    @GetMapping("/")
    public String about_us() {
        return "index";
    }

    @GetMapping("/events")
    public String events() {
        return "events";
    }

    @GetMapping("/events-employee")
    public String events_employee() {
        return "events-employee";
    }

    @GetMapping("/reservation")
    public String reservation() {
        return "reservation";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    /*Her skal vi både bruge en GetMapping og en PostMapping*/
    @GetMapping("/test")
    public String test1() {return "Test-site";}

    /*Her skal vi bruge "ModelAttribute" og refere til vores model klasse (reservation)
     * Derefter skal vi bruge "Model" hvor vi kan gemme vores variabler i fra vores froms
     * De bliver så retuneret til test site*/
    @PostMapping("/test")
    public String test(@ModelAttribute Reservation reservation, Model model)
    {
        model.addAttribute("testName", reservation.getFullName());
        model.addAttribute("testTelephone", reservation.getPhone());
        model.addAttribute("TestEmail", reservation.getEmail());
        model.addAttribute("NumOfPeople", reservation.getNumberOfGuests());
        model.addAttribute("Testmessage", reservation.getMessage() );
        return "Test-site";}
}
