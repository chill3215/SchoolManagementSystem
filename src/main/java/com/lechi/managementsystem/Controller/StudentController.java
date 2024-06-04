package com.lechi.managementsystem.Controller;

import com.lechi.managementsystem.Model.Entity.Student;
import com.lechi.managementsystem.Model.Entity.Teacher;
import com.lechi.managementsystem.Model.Enum.UserRole;
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
        model.addAttribute("role", UserRole.STUDENT);
        return "formAdd";
    }

    @GetMapping("/all")
    public String getAllStudent(Model model){
        model.addAttribute("users", studentService.getAll());
        model.addAttribute("role", UserRole.STUDENT);
        return "list";
    }

    @PostMapping("")
    public String addStudent(@ModelAttribute Student student){

        studentService.add(student);
        return "redirect:/student/all";
    }

    @GetMapping("/{id}")
    public String seeDetails(@PathVariable("id") Integer id, Model model){
        Student foundStudent=studentService.getById(id);
        model.addAttribute("user", foundStudent);
        return "profile";

    }

    @GetMapping("/{id}/updateForm")
    public String getUpdateForm(@PathVariable("id") Integer id, Model model){
        Student foundStudent = studentService.getById(id);
        model.addAttribute("user", foundStudent);
        return "updateForm";
    }

    @PostMapping("/{id}/updated")
    public String saveUpdatedStudent(@PathVariable("id") Integer id,@ModelAttribute Student updatedStudent, Model model){
        studentService.update(updatedStudent);
        return "redirect:/student/"+id;
    }

    @PostMapping("{id}")
    public String handelDelete(@PathVariable("id") Integer id, @RequestParam("_method") String method, Model model){
        if(method.equalsIgnoreCase("delete")){
            return deleteStudent(id);
        }
        model.addAttribute("message", "oops! this user can not be deleted");
        return "error";

    }
    @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable("id") Integer id){
        studentService.deleteById(id);
        return "redirect:/student/all";
    }






}
