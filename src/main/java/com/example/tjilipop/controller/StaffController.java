package com.example.tjilipop.controller;

import com.example.tjilipop.model.Event;
import com.example.tjilipop.model.Login;
import com.example.tjilipop.model.MenuItem;
import com.example.tjilipop.model.Reservation;
import com.example.tjilipop.repository.CRUDInterface;
import com.example.tjilipop.repository.EventsRepository;
import com.example.tjilipop.repository.MenuItemRepository;
import com.example.tjilipop.repository.ReservationsRepository;
import com.example.tjilipop.utility.PasswordManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {
    private PasswordManager passwordManager = new PasswordManager();
    private CRUDInterface<Reservation> reservationsRepository = new ReservationsRepository();
    private CRUDInterface<Event> eventsRepository = new EventsRepository();
    private CRUDInterface<MenuItem> menuItemRespository = new MenuItemRepository();
    //private LoginService loginService = new LoginService();

    @GetMapping()
    public String loginPage() {
        return "staff-login";
    }

    @PostMapping()
    public String login(@ModelAttribute Login loginData, HttpSession session, Model model) {
        /*if(loginService.isPasswordValid(loginData)) {
          session.setAttribute("login", loginData);
            return "redirect:/staff-frontpage";
        } else {
            model.addAttribute("status","Invalid login");*/
            return "staff-login";
        //}
    }

    @GetMapping("/staff-frontpage")
    public String frontPage(HttpServletRequest request, Model model) {
        //if(request.getSession() != null) {
            return "staff-frontpage";
       /* } else {
            model.addAttribute("status","You have to be logged in before entering staff page");
            return "staff-login";
        }*/
    }

    @GetMapping("/reservation-requests")
    public String reservationRequests(HttpServletRequest request, Model model) {
        List<Reservation> reservationList = reservationsRepository.getList();
        model.addAttribute("reservations", reservationList);
        //if(request.getSession() != null) {

            return "staff-reservation-requests";
        /*} else {
            model.addAttribute("status","You have to be logged in before entering staff page");
            return "staff-login";
        }*/
    }

    @GetMapping("/edit-events")
    public String editEvents(HttpServletRequest request, Model model) {
        //if(request.getSession() != null) {
            return "staff-edit-events";
        /*} else {
            model.addAttribute("status","You have to be logged in before entering staff page");
            return "staff-login";
        }*/
    }

    @GetMapping("/edit-menu")
    public String editMenu(HttpServletRequest request, Model model) {
        //if(request.getSession() != null) {
            return "staff-edit-menu";
       /* } else {
            model.addAttribute("status","You have to be logged in before entering staff page");
            return "staff-login";
        }*/
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/profile-settings")
    public String profileSettings(HttpServletRequest request, Model model) {
        //if(request.getSession() != null) {
            return "staff-profile-settings";
        /*} else {
            model.addAttribute("status","You have to be logged in before entering staff page");
            return "staff-login";
        }*/
    }
}
