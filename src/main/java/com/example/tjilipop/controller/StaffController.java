package com.example.tjilipop.controller;

import com.example.tjilipop.model.*;
import com.example.tjilipop.repository.CRUDInterface;
import com.example.tjilipop.repository.EventsRepository;
import com.example.tjilipop.repository.MenuItemRepository;
import com.example.tjilipop.repository.ReservationsRepository;
import com.example.tjilipop.service.LoginService;
import com.example.tjilipop.utility.LoginManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
//Rasmus's kode
@Controller
@RequestMapping("/staff")
public class StaffController {
    private LoginManager loginManager = new LoginManager();
    private CRUDInterface<Reservation> reservationsRepository = new ReservationsRepository();
    private CRUDInterface<Event> eventsRepository = new EventsRepository();
    private CRUDInterface<MenuItem> menuItemRespository = new MenuItemRepository();
    private LoginService loginService = new LoginService();
    //Session er implementeret for at teste om der er logget ind, før man kan bruge staffsektionen
    @GetMapping()
    public String loginPage(HttpSession session) {
        if(session.getAttribute("login") != null) {
            return "staff-frontpage";
        } else {
            return "staff-login";
        }
    }

    @PostMapping()
    public String login(@ModelAttribute Login loginData, HttpSession session, Model model) {
        if(loginService.doPasswordAndUsernameMatch(loginData.getUsername(),loginData.getPassword())) {
          session.setAttribute("login", loginData.getPassword());
            return "staff-frontpage";
        } else {
            model.addAttribute("status","Invalid username and/or password. Please try again.");
            return "staff-login";
        }
    }

    @GetMapping("/staff-frontpage")
    public String frontPage(HttpSession session, Model model) {
        if(session.getAttribute("login") != null) {
            return "staff-frontpage";
        } else {
            model.addAttribute("status","You have to be logged in before entering staff page");
            return "staff-login";
        }
    }
    //Her hentes en liste fra database og sendes til view
    @GetMapping("/reservation-requests")
    public String reservationRequests(HttpSession session, Model model) {
        List<Reservation> reservationList = reservationsRepository.getList("reservation");
        model.addAttribute("reservations", reservationList);
        if(session.getAttribute("login") != null) {
            return "staff-reservation-requests";
        } else {
            model.addAttribute("status","You have to be logged in before entering staff page");
            return "staff-login";
        }
    }
    //Events
    @GetMapping("/edit-events")
    public String editEvents(HttpSession session, Model model) {
        List<Event> events = eventsRepository.getList("event");
        if(session.getAttribute("login") != null) {
            model.addAttribute("events", events);
            return "staff-edit-events";
        } else {
            model.addAttribute("status","You have to be logged in before entering staff page");
            return "staff-login";
        }
    }

    @GetMapping("/edit-events/event-settings/{id}")
    public String eventSettings(@PathVariable int id, HttpSession session, Model model) {
        if(session.getAttribute("login") != null) {
            model.addAttribute("event",eventsRepository.getSingleEntity(id));
            return "staff-event-settings";
        } else {
            model.addAttribute("status","You have to be logged in before entering staff page");
            return "staff-login";
        }
    }

    @PostMapping("/edit-events/event-settings/")
    public String eventSettingsData(@ModelAttribute Event eventData) {
        eventsRepository.insert(eventData);
        return "staff-event-settings";
    }
    //Menu
    @GetMapping("/edit-menu")
    public String editMenu(HttpSession session, Model model) {
        List<MenuItem> menuItems = menuItemRespository.getList("beer");
        model.addAttribute("menuItems", menuItems);
        if(session.getAttribute("login") != null) {
            return "staff-edit-menu";
        } else {
            model.addAttribute("status", "You have to be logged in before entering staff page");
            return "staff-login";
        }
    }

    @PostMapping ("/edit-menu/delete/{id}")
    public String deleteMenuItem(HttpSession session, @PathVariable int id, Model model) {

        menuItemRespository.delete(id);
        if(session.getAttribute("login") != null) {
            List<MenuItem> menuItems = menuItemRespository.getList("beer");
            model.addAttribute("menuItems", menuItems);
            return "staff-edit-menu";
        } else {
            model.addAttribute("status", "You have to be logged in before entering staff page");
            return "staff-login";
        }
    }

    @GetMapping("/edit-menu/edit-menu-item/{id}")
    public String editMenuItem(@PathVariable int id, HttpSession session, Model model) {
        if(session.getAttribute("login") != null) {
            model.addAttribute("menuItem", menuItemRespository.getSingleEntity(id));
            return "staff-edit-menu-item";
        } else {
            model.addAttribute("status", "You have to be logged in before entering staff page");
            return "staff-login";
        }
    }

    @PostMapping("/edit-menu/edit-menu-item/{id}")
    public String retrieveMenuItem(@PathVariable int id, HttpSession session, Model model) {

        if(session.getAttribute("login") != null) {
            model.addAttribute("menuItem", menuItemRespository.getSingleEntity(id));
            return "staff-edit-menu-item";
        } else {
            model.addAttribute("status", "You have to be logged in before entering staff page");
            return "staff-login";
        }
    }

    @PostMapping("/edit-menu/edit-menu-item")
    public String updateMenuItem(@ModelAttribute MenuItem menuItem, HttpSession session, Model model) {
        menuItemRespository.update(menuItem);
        if(session.getAttribute("login") != null) {
            model.addAttribute("menuItem", menuItemRespository.getSingleEntity(menuItem.getId()));
            model.addAttribute("message","The item has been successfully updated");
            return "redirect:/staff/edit-menu";
        } else {
            model.addAttribute("status", "You have to be logged in before entering staff page");
            return "staff-login";
        }
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/profile-settings")
    public String profileSettings(HttpSession session, Model model) {
        if(session.getAttribute("login") != null) {
            return "staff-profile-settings";
        } else {
            model.addAttribute("status","You have to be logged in before entering staff page");
            return "staff-login";
        }
    }

    @PostMapping("/profile-settings")
    public String updateProfile(@ModelAttribute ProfileSetting profileSetting, Model model) {
        String username = profileSetting.getUsername();
        String password = profileSetting.getPassword();
        String newPassword1 = profileSetting.getNewPassword1();
        String newPassword2 = profileSetting.getNewPassword2();

        if (loginService.doPasswordAndUsernameMatch(username,password)) {
            if(loginService.arePasswordsIdentical(newPassword1,newPassword2)) {
                if(loginService.isPasswordValid(newPassword1)) {
                    Login login = new Login(profileSetting.getUsername(),profileSetting.getNewPassword1());
                    loginManager.updateLogin(login);
                    model.addAttribute("status", "Login was successfully updated");
                    return "staff-profile-settings";
                }
                model.addAttribute("status", "Password exceeds a maximum of 50 characters");
                return "staff-profile-settings";
            }
            model.addAttribute("status", "Passwords are not identical");
            return "staff-profile-settings";
        }
        model.addAttribute("status", "Username and/or password is incorrect");
       return "staff-profile-settings";
    }

    @GetMapping("/invalidate-session")
    public String invalidate(HttpSession session){
        session.invalidate();
        return "staff-login";
    }
}
