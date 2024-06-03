package com.lechi.managementsystem.Controller;

import com.lechi.managementsystem.Model.Entity.Student;
import com.lechi.managementsystem.Model.Entity.Teacher;
import com.lechi.managementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("/form")
    public String getFormStudent(Model model){
        model.addAttribute("user", new Student());
//        model.addAttribute("studentId", true);
        return "formAdd";
    }

    @PostMapping("")
    public void addStudent(@ModelAttribute Student student){
        studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public String seeDetails(@PathVariable("id") Integer id, Model model){
        Student foundStudent=studentService.getStudentById(id);
        model.addAttribute("user", foundStudent);
        return "profile";

    }


}
