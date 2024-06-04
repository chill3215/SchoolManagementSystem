package com.lechi.managementsystem.Controller;

import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Service.StudentService;
import com.lechi.managementsystem.Service.TeacherService;
import com.lechi.managementsystem.Service.UserMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("currentUser")
public class AdminController {

    @Autowired
    private UserMainService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;



    @GetMapping("/authen")
    public String authenticate(@ModelAttribute User user, Model model){
        User foundUser = userService.findByEmail(user.getEmail());
        if (foundUser.getPassword().equals(user.getPassword())
                && foundUser.getUserRole().equals(user.getUserRole())) {
            model.addAttribute("currentUser", foundUser);
            model.addAttribute("user", foundUser);
            return inforPortal(model);
        }
        return "error";
    }

    @ModelAttribute("currentUser")
    public User getCurrentUser(Model model){
        return new User();
    }

    public String inforPortal(Model model){
        long countUsers = userService.count();
        long countTeachers = teacherService.count();
        long countStudents = studentService.count();
        model.addAttribute("countUsers", countUsers);
        model.addAttribute("countTeachers", countTeachers);
        model.addAttribute("countStudents", countStudents);
        return "portal";
    }




}
