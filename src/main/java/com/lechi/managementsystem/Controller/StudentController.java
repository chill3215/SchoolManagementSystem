package com.lechi.managementsystem.Controller;

import com.lechi.managementsystem.Error.UserCannotBeAddedException;
import com.lechi.managementsystem.Model.Dto.StudentDTO;
import com.lechi.managementsystem.Model.Entity.Score;
import com.lechi.managementsystem.Model.Entity.Student;
import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import com.lechi.managementsystem.Service.StudentService;
import com.lechi.managementsystem.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")

public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    @GetMapping("/form")
    public String getFormStudent(Model model){
        model.addAttribute("user", new Student());
        model.addAttribute("role", UserRole.STUDENT);
        return "formUser";
    }

    @GetMapping("/all")
    public String getAllStudent(@SessionAttribute("currentUser")User user, Model model){
        model.addAttribute("users", studentService.getAll());
        model.addAttribute("role", UserRole.STUDENT);
        model.addAttribute("currentUser", user);
        return "listUser";
    }

    @PostMapping("")
    public String addStudent(@ModelAttribute Student student) throws UserCannotBeAddedException {
        studentService.add(student);
        return "redirect:/student/all";
    }

    @GetMapping("/{id}")
    public String seeDetails(@SessionAttribute("currentUser") User user, @PathVariable("id") Integer id, Model model){
        StudentDTO foundStudent=studentService.getDTOById(id);
        model.addAttribute("user", foundStudent);
        model.addAttribute("currentUser", user);
        return "profile";

    }

    @GetMapping("/{id}/updateForm")
    public String getUpdateForm(@PathVariable("id") Integer id, Model model){
        StudentDTO foundStudent = studentService.getDTOById(id);
        model.addAttribute("user", foundStudent);
        return "updateFormUser";
    }

    @PostMapping("/{id}/updated")
    public String saveUpdatedStudent(@PathVariable("id") Integer id,@ModelAttribute StudentDTO updatedStudent, Model model){
        studentService.update(updatedStudent);
        return "redirect:/student/"+id;
    }

    @PostMapping("{id}")
    public String handleDelete(@PathVariable("id") Integer id, @RequestParam("_method") String method, Model model){
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

    @GetMapping("/{studentId}/score/all")
    public String getScore(@PathVariable("studentId") Integer studentId, Model model, @SessionAttribute("currentUser") User user){
        model.addAttribute("student", studentService.getById(studentId));
        model.addAttribute("subjects", subjectService.getAll());
        model.addAttribute("currentUser", user);
        return "listScore";
    }

    @PostMapping("/{studentId}/score")
    public String addScore(@PathVariable("studentId") Integer studentId, Model model, @ModelAttribute Score score) {
        studentService.addScore(studentId, score);
        return "redirect:/student/"+studentId+"/score/all";
    }

    @GetMapping("/{studentId}/updateScore/{scoreId}")
    public String getUpdateScore(@PathVariable("studentId") Integer studentId, Model model, @PathVariable("scoreId") Integer scoreId) {
        model.addAttribute("score", studentService.getById(studentId).getSubjects());
        return "redirect:/student/"+studentId+"/score/all";
    }

    @PostMapping("/{studentId}/updateScore/{scoreId}")
    public String updateScore(@PathVariable("studentId") Integer studentId, Model model, @ModelAttribute Score score,  @PathVariable("scoreId") Integer scoreId) {
        studentService.updateScore(studentId, score);
        return "redirect:/student/"+studentId+"/score/all";
    }

    @PostMapping("/{studentId}/score/{scoreId}")
    public String handelDeleteScore(@PathVariable("studentId") Integer studentId, @RequestParam("_method") String method, Model model, @PathVariable("scoreId") Integer scoreId){
        if(method.equalsIgnoreCase("delete")){
            return deleteScore(studentId, scoreId);
        }
        model.addAttribute("message", "oops! this score can not be deleted");
        return "error";

    }

    @DeleteMapping("/{studentId}/score/{scoreId}")
    public String deleteScore(@PathVariable("studentId") Integer studentId, @PathVariable("scoreId") Integer deletedScoreId) {
        studentService.deleteScore(studentId, deletedScoreId);
        return "redirect:/student/"+studentId+"/score/all";
    }

}
