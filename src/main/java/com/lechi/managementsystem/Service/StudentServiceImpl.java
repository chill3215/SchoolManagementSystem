package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Entity.Student;
import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import com.lechi.managementsystem.Repository.StudentRepository;
import com.lechi.managementsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;



    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void add(Student student) {
        student.setUserRole(UserRole.STUDENT);
        studentRepository.save(student);
    }

    @Override
    public Student findByEmail(String email) {
        return null;
    }

    @Override
    public Student getById(Integer id) {
        return studentRepository.getStudentsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }
    @Override
    public void update(Student updatedStudent) {
        Student existingStudent = getById(updatedStudent.getId());
        if(existingStudent!=null){
            existingStudent.setFullname(updatedStudent.getFullname());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setDob(updatedStudent.getDob());
            studentRepository.save(existingStudent);
        }


    }

    @Override
    public long count() {
        return studentRepository.count();
    }


}
