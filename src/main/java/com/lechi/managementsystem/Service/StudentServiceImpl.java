package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Entity.Student;
import com.lechi.managementsystem.Repository.StudentRepository;
import com.lechi.managementsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.getStudentsById(id);
    }


}
