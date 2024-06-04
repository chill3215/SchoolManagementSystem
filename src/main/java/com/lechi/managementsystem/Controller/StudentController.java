package com.lechi.managementsystem.Controller;

import com.lechi.managementsystem.Model.Entity.Student;
import com.lechi.managementsystem.Model.Entity.Teacher;
import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import com.lechi.managementsystem.Service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

//    public User getCurrentUser(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        return (User) session.getAttribute("currentUser");
//    }

    @Autowired
    StudentService studentService;
    @GetMapping("/form")
    public String getFormStudent(Model model){
        model.addAttribute("user", new Student());
        model.addAttribute("role", UserRole.STUDENT);
        return "formAdd";
    }

    @GetMapping("/all")
    public String getAllStudent(@SessionAttribute("currentUser")User user, Model model){
        model.addAttribute("users", studentService.getAll());
        model.addAttribute("role", UserRole.STUDENT);
        model.addAttribute("currentUser", user);
//        User currentUser = getCurrentUser()
        return "list";
    }

    @PostMapping("")
    public String addStudent(@ModelAttribute Student student){

        studentService.add(student);
        return "redirect:/student/all";
    }

    @GetMapping("/{id}")
    public String seeDetails(@SessionAttribute("currentUser") User user, @PathVariable("id") Integer id, Model model){
        Student foundStudent=studentService.getById(id);
        model.addAttribute("user", foundStudent);
        model.addAttribute("currentUser", user);
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
