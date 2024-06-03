package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Entity.Student;

public interface StudentService {

    public void addStudent(Student student);

    public Student getStudentById(Integer id);
}
