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
public class MainController {

    @Autowired
    private UserMainService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;
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
            model.addAttribute("currentUser", foundUser);
            model.addAttribute("user", foundUser);
            return "portal";
        }
        return "error";
    }

    @ModelAttribute("currentUser")
    public User getCurrentUser(Model model){
        return new User();
    }

    //auf gleicher Klasse, ist nicht erforderlich nochmal die Attribute zu definieren
    //auf anderer Klasse, ist mit @SessionAttribute zu annotieren, um Attribute in Session abzurufen und dann in Model hinzuzufügen
    @ModelAttribute
    public void infoPortal(Model model){
        model.addAttribute("countUsers", userService.count());
        model.addAttribute("countTeachers", teacherService.count());
        model.addAttribute("countStudents", studentService.count());
    }

    


}
