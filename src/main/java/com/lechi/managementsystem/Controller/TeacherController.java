package com.lechi.managementsystem.Controller;

import com.lechi.managementsystem.Error.UserCannotBeAddedException;
import com.lechi.managementsystem.Model.Dto.TeacherDTO;
import com.lechi.managementsystem.Model.Entity.Teacher;
import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import com.lechi.managementsystem.Service.SubjectService;
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

    @Autowired
    SubjectService subjectService;

    @GetMapping("/form")
    public String getFormTeacher(Model model){
        model.addAttribute("user", new Teacher());
        model.addAttribute("role", UserRole.TEACHER);
        model.addAttribute("subjects", subjectService.getAll());
        return "formUser";
    }

    @GetMapping("/all")
    public String getAllTeacher(@SessionAttribute("currentUser") User user, Model model){
        model.addAttribute("users", teacherService.getAll());
        model.addAttribute("role", UserRole.TEACHER);
        model.addAttribute("currentUser", user);
        return "listUser";
    }

    @PostMapping("")
    public String addTeacher(@ModelAttribute Teacher teacher) throws UserCannotBeAddedException {
        teacherService.add(teacher);
        return "redirect:/teacher/all";
    }

    @GetMapping("/{id}")
    public String seeDetails(@SessionAttribute("currentUser") User user, @PathVariable("id") Integer id, Model model){
        Teacher foundTeacher=teacherService.getById(id);
        model.addAttribute("user", foundTeacher);
        model.addAttribute("currentUser", user);
        return "profile";
    }

    @GetMapping("/{id}/updateForm")
    public String getUpdateForm(@PathVariable("id") Integer id, Model model){
        Teacher foundTeacher = teacherService.getById(id);
        model.addAttribute("user", foundTeacher);
        model.addAttribute("allSubjects", subjectService.getAll());
        return "updateFormUser";
    }

    @PostMapping("/{id}/updated")
    public String saveUpdatedTeacher(@PathVariable("id") Integer id, @ModelAttribute TeacherDTO updatedTeacher, Model model){
        teacherService.update(updatedTeacher);
        return "redirect:/teacher/"+id;
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
