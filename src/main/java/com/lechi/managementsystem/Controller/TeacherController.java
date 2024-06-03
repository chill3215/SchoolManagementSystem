package com.lechi.managementsystem.Controller;

import com.lechi.managementsystem.Model.Entity.Student;
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

    @GetMapping("/all")
    public String getAllTeacher(Model model){
        model.addAttribute("users", teacherService.getAll());
        return "list";
    }

    @PostMapping("")
    public void addTeacher(@ModelAttribute Teacher teacher){
        teacherService.add(teacher);
    }

    @GetMapping("/{id}")
    public String seeDetails(@PathVariable("id") Integer id, Model model){
        Teacher foundTeacher=teacherService.getById(id);
        model.addAttribute("user", foundTeacher);
        return "profile";

    }

    @GetMapping("/{id}/updateForm")
    public String getUpdateForm(@PathVariable("id") Integer id, Model model){
        Teacher foundTeacher = teacherService.getById(id);
        model.addAttribute("user", foundTeacher);
        return "updateForm";
    }

    @PutMapping("/{id}")
    public String saveUpdatedTeacher(@PathVariable("id") Integer id, @ModelAttribute Teacher updatedTeacher, Model model){
        teacherService.update(updatedTeacher);
        return "redirect:/teacher/seeTeacher/"+id;
    }

    @PostMapping("{id}")
    public String handelDelete(@PathVariable("id") Integer id, @RequestParam("_method") String method, Model model){
        if(method.equalsIgnoreCase("delete")){
            return deleteTeacher(id);
        }
        model.addAttribute("message", "oops! this user can not be deleted");
        return "error";

    }
    @DeleteMapping("{id}")
    public String deleteTeacher(@PathVariable("id") Integer id){

        teacherService.deleteById(id);
        return "redirect:/teacher/all";

    }
}
