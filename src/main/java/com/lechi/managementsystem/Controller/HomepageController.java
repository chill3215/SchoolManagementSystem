package com.lechi.managementsystem.Controller;

import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import com.lechi.managementsystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomepageController {

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String homepage(){
        return "homepage";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/authen")
    public String authenticate(@ModelAttribute User user, Model model){
        User foundUser = userService.findByEmail(user.getEmail());
        if (foundUser.getPassword().equals(user.getPassword())
                && foundUser.getUserRole().equals(user.getUserRole())) {
            model.addAttribute("user", foundUser);
            return (foundUser.getUserRole() == UserRole.ADMIN)? "user":"error";
        }
        return "error";
    }
}
