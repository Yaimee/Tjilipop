package com.example.tjilipop.controller;

import com.example.tjilipop.model.MenuItem;
import com.example.tjilipop.model.Reservation;
import com.example.tjilipop.repository.CRUDInterface;
import com.example.tjilipop.repository.MenuItemRepository;
import com.example.tjilipop.repository.ReservationsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private CRUDInterface<Reservation> reservationsRepository = new ReservationsRepository();
    private CRUDInterface<MenuItem> MenuItemRepository = new MenuItemRepository();
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

    @GetMapping("/menu")
    public String menu(@ModelAttribute MenuItem menuItem, Model model) {

        model.addAttribute("menuItems", MenuItemRepository.getList("øl"));
        return "menu-øl";
    }

    @GetMapping("/menu-vin")
    public String menu_Vin(@ModelAttribute MenuItem menuItem, Model model) {

        model.addAttribute("menuItems", MenuItemRepository.getList("vin"));
        return "menu-vin";}

    @GetMapping("/menu-spiritus")
    public String menu_spiritus(@ModelAttribute MenuItem menuItem, Model model) {

        model.addAttribute("menuItems", MenuItemRepository.getList("spiritus"));
        return "menu-spiritus";}

    @GetMapping("/menu-uden-alc")
    public String menu_uden_procent(@ModelAttribute MenuItem menuItem, Model model) {

        model.addAttribute("menuItems", MenuItemRepository.getList("uden"));
        return "menu-uden-alc";}

    @GetMapping("/menu-mad")
    public String menu_mad(@ModelAttribute MenuItem menuItem, Model model) {

        model.addAttribute("menuItems", MenuItemRepository.getList("mad"));
        return "menu-mad";}

    /*Her skal vi både bruge en GetMapping og en PostMapping*/
    @GetMapping("/test")
    public String test1() {return "Test-site";}

    /*Her skal vi bruge "ModelAttribute" og refere til vores model klasse (reservation)
     * Derefter skal vi bruge "Model" hvor vi kan gemme vores variabler i fra vores froms
     * De bliver så retuneret til test site*/
    @PostMapping("/test")
    public String test(@ModelAttribute Reservation reservation, Model model)
    {
        model.addAttribute("testName", reservation.getFullname());
        model.addAttribute("testTelephone", reservation.getTelephone());
        model.addAttribute("TestEmail", reservation.getEmail());
        model.addAttribute("NumOfPeople", reservation.getNum_of_people());
        model.addAttribute("Testmessage", reservation.getMessage());

        reservationsRepository.insert(reservation);

        return "Test-site";}
}
