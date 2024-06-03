package com.lechi.managementsystem.Controller;

import com.lechi.managementsystem.Model.Entity.Teacher;
import com.lechi.managementsystem.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @GetMapping("/form")
    public String getFormTeacher(Model model){
        model.addAttribute("user", new Teacher());
//        model.addAttribute("teacherId", true);
        return "formAdd";
    }

    @PostMapping("")
    public void addTeacher(@ModelAttribute Teacher teacher){
        teacherService.addTeacher(teacher);
    }

    @GetMapping("/{id}")
    public String seeDetails(@PathVariable("id") Integer id, Model model){
        Teacher foundTeacher=teacherService.getTeacherById(id);
        model.addAttribute("user", foundTeacher);
        return "profile";

    }
}
