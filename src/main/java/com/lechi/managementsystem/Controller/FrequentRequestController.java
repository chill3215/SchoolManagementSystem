package com.lechi.managementsystem.Controller;

import com.lechi.managementsystem.Model.Entity.Student;
import com.lechi.managementsystem.Model.Entity.Teacher;
import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrequentRequestController {



//    public static String mainPage(Model model, UserRole userRole){
//        return "portal";
//    }

//    @GetMapping("/portal")
//    public static String loginUser(HttpServletRequest request, User user, Model model) {
//        HttpSession session = request.getSession();
//        session.setAttribute("currentUser", user);
//        return "portal";
//    }
//
//    public User getCurrentUser(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        return (User) session.getAttribute("currentUser");
//    }





}
