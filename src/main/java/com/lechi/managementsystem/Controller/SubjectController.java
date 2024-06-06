package com.lechi.managementsystem.Controller;

import com.lechi.managementsystem.Model.Entity.Subject;
import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/")
    public String addSubject(@ModelAttribute Subject subject) {
        subjectService.add(subject);
        return "redirect:/subject/all";
    }

    @GetMapping("/{id}")
    public String getSubject(@PathVariable("id") Integer id, Model model, @SessionAttribute("currentUser") User user){
        Subject subject = subjectService.getById(id);
        model.addAttribute("subject", subject);
        model.addAttribute("currentUser", user);
        return "subjectDetails";
    }

    @GetMapping("/all")
    public String getAllSubjects(@SessionAttribute("currentUser") User user,Model model){
        List<Subject> subjects = subjectService.getAll();
        model.addAttribute("subjects", subjects);
        model.addAttribute("currentUser", user);
        return "listSubject";
    }

    @PostMapping("{id}")
    public String handelDelete(@PathVariable("id") Integer id, @RequestParam("_method") String method, Model model){
        if(method.equalsIgnoreCase("delete")){
            return deleteSubject(id);
        }
        model.addAttribute("message", "oops! this subject can not be deleted");
        return "error";

    }

    @DeleteMapping("/")
    public String deleteSubject(Integer id){

        subjectService.delete(id);
        return "redirect:/subject/all";
    }

    @GetMapping("/form")
    public String getFormSubject(Model model){
        model.addAttribute("subject", new Subject());
        return "formSubject";
    }

    @GetMapping("/{id}/updateForm")
    public String getUpdateForm(@PathVariable("id") Integer id, Model model){
        Subject subject = subjectService.getById(id);
        model.addAttribute("subject", subject);
        return "updateFormSubject";
    }

    @PostMapping("/{id}/update")
    public String updatedSubject(@ModelAttribute Subject subject, @PathVariable("id") Integer id){
        subjectService.update(subject);
        return "redirect:/subject/"+id;
    }








}
